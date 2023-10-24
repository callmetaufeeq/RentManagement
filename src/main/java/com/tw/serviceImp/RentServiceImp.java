package com.tw.serviceImp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tw.conv.RentConvertor;
import com.tw.customRepo.RentExternalRepo;
import com.tw.customRepo.RentExternalRepoYear;
import com.tw.customRepo.RentExternalYearOwner;
import com.tw.dto.HistoryRentDto;
import com.tw.dto.PageDto;
import com.tw.dto.RentDto;
import com.tw.dto.RentListDto;
import com.tw.dto.RentReportDto;
import com.tw.dto.RentSlaveDto;
import com.tw.dto.RentSummaryDTO;
import com.tw.dto.RentYearOwnerId;
import com.tw.generics.AppConstants;
import com.tw.generics.Code;
import com.tw.generics.Messages;
import com.tw.generics.Response;
import com.tw.model.DictionaryCount;
import com.tw.model.Rent;
import com.tw.model.RentSlave;
import com.tw.model.ReportSpecification;
import com.tw.model.Shop;
import com.tw.model.ShopOwner;
import com.tw.model.User;
import com.tw.repository.DictionaryRepository;
import com.tw.repository.OwnerRepository;
import com.tw.repository.RentRepository;
import com.tw.repository.RentSlaveRepository;
import com.tw.repository.ShopRepository;
import com.tw.repository.UserRepository;
import com.tw.service.RentService;
import com.tw.spec.RentSpec;
import com.tw.spec.RentSpecDto;
import com.tw.spec.RentSpecification;
import com.tw.utility.Constant;

@Service
public class RentServiceImp implements RentService {

	@Autowired
	private RentRepository rentRepository;

	@Autowired
	RentExternalRepo rentExternalRepo;

	@Autowired
	RentExternalRepoYear RentExternalRepoYear;

	@Autowired
	RentExternalYearOwner rentExternalYearOwner;

	@Autowired
	private OwnerRepository shopownerRepo;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private ShopRepository shopRepo;

	@Autowired
	private RentSlaveRepository rentSlaveRepo;

	@Autowired
	private DictionaryRepository dictionaryRepo;

	@SuppressWarnings("deprecation")
	@Override
	public ResponseEntity<?> saveRent(RentDto r) {
		String msg = "";
		Rent obj = new Rent();
		if (r.getId() != null && r.getId() > 0) {
			obj = rentRepository.getById(r.getId());
			obj.setModified(Calendar.getInstance());
			msg = "Rent " + Messages.UPDATED_MSG;
		} else {
			msg = "Rent " + Messages.CREATED_MSG;
			obj.setModified(Calendar.getInstance());
			obj.setCreated(Calendar.getInstance());
			obj.setId(r.getId());
		}
		obj.setReceiptDate(r.getReceiptDate());
		obj.setTotalPaid(r.getTotalPaid());
		obj.setReceiptNo(r.getReceiptNo());
		obj.setTotalRemaining(r.getTotalRemaining());
		obj.setTotalRentAmount(r.getTotalRentAmount());
		obj.setTotalDepositAmount(r.getTotalRentAmount());
		obj.setYear(r.getYear());

		if (r.getTotalRemaining() > 0) {
			obj.setStatus("Pending");
		} else {
			obj.setStatus("Nill");
		}
		if (r.getShopownerId() != null && r.getShopownerId() > 0) {
			ShopOwner sw = shopownerRepo.getById(r.getShopownerId());
			obj.setShopowner(sw);
		}
		if (r.getUserId() != null && r.getUserId() > 0) {
			User u = userrepo.getById(r.getUserId());
			obj.setUser(u);
		}
		if (r.getRentSlave() != null) {
			List<RentSlave> rentSlavelist = new ArrayList<RentSlave>();
			for (RentSlaveDto s : r.getRentSlave()) {
				RentSlave t = new RentSlave();
				BeanUtils.copyProperties(s, t);
				if (s.getShopId() != null && s.getShopId() > 0) {
					Shop shop = shopRepo.getById(s.getShopId());
					t.setShop(shop);
				}
				t.setCreated(Calendar.getInstance());
				t.setModified(Calendar.getInstance());
				t.setRent(obj);
				rentSlavelist.add(t);
			}
			obj.setRentSlave(rentSlavelist);
		}
		Rent rr = rentRepository.save(obj);
		if (rr != null) {
			DictionaryCount count = dictionaryRepo.getByType(Constant.RECEIPT_NO);
			count.setCount(count.getCount() + 1);
			dictionaryRepo.save(count);
		}
		return Response.build(Code.OK, msg);
	}

	@Override
	public ResponseEntity<Rent> getRentById(Long id) {
		Optional<Rent> rent = rentRepository.findById(id);
		try {
			return new ResponseEntity<>(rent.get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(rent.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> delete(Long id) {
		rentRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@SuppressWarnings("deprecation")
	@Override
	public ResponseEntity<String> changeStatus(Long id) {
		Rent obj = rentRepository.getById(id);
		obj.setDeleted(true);
		rentRepository.save(obj);
		return new ResponseEntity<>("Status changed successfully ", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Long> totalAmount() {
		Long totalAmount = rentRepository.totalAmount();
		try {
			return new ResponseEntity<>(rentRepository.totalAmount(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(totalAmount, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Long> paidAmount() {
		Long paidAmount = rentRepository.paidAmount();
		try {
			return new ResponseEntity<>(rentRepository.paidAmount(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(paidAmount, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Long> remainingAmount() {
		Long remainingAmount = rentRepository.remainingAmount();
		try {
			return new ResponseEntity<>(rentRepository.remainingAmount(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(remainingAmount, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Rent>> findByShopOwnerId(Long id) {
		try {
			return new ResponseEntity<>(rentRepository.findByShopownerId(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<RentDto>> findSum(Long id, String year) {
		try {
			new ResponseEntity<>(rentExternalRepo.findSum(id, year), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<RentSummaryDTO>> findByYear(String year) {
		try {
			return new ResponseEntity<>(RentExternalRepoYear.findByYear(year), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> findByShopOwnerIdAndYear(Long id, String year) {
		List<RentYearOwnerId> list = rentExternalYearOwner.findByShopOwnerIdAndYear(id, year);
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> findAllRent(RentSpecDto dto) {
		PageRequest pg = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<Rent> r = rentRepository
				.findAll(new RentSpec(dto.getShopownerName(), dto.getShopName(), dto.getStatus(), dto.getYear()), pg);
		List<RentListDto> listDto = r.stream().map(new RentConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(listDto, r.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

	@Override
	public ResponseEntity<?> getRent() {
		List<Rent> r = rentRepository.findAll();
		List<RentListDto> listDto = r.stream().map(new RentConvertor()).collect(Collectors.toList());
		return Response.build(Code.OK, listDto);
	}

	@Override
	public ResponseEntity<?> findAllRentNew(RentSpecDto dto) {

		PageRequest pg = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);

		Specification<Rent> spec = RentSpecification.buildSpecification(dto);

		Page<Rent> r = rentRepository.findAll(spec, pg);

		List<RentListDto> listDto = r.stream().map(new RentConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(listDto, r.getTotalElements());

		return Response.build(Code.OK, pageDto);
	}

	@Override
	public ResponseEntity<?> getAmt(Long shopId, String year, String rentType) {

		Double rentAmount = 0.0;
		Double depositAmount = 0.0;
		Double paidAmount = 0.0;
		Double remainingAmount = 0.0;

		paidAmount = rentSlaveRepo.getSumPaid(shopId, year, rentType);
		paidAmount = paidAmount != null ? paidAmount : 0.0;

		if ("R".equals(rentType)) {
			rentAmount = rentSlaveRepo.getRentAmount(shopId, year, rentType);
			if (rentAmount == null || rentAmount == 0.0) {
				Shop obj = shopRepo.getById(shopId);
				rentAmount = obj.getRent();
			}
			remainingAmount = rentAmount - paidAmount;
		} else {
			depositAmount = rentSlaveRepo.getDepositAmount(shopId, year, rentType);

			if (depositAmount == null || depositAmount == 0.0) {
				Shop obj = shopRepo.getById(shopId);
				depositAmount = obj.getDepositAmount();
			}
			remainingAmount = depositAmount - paidAmount;
		}
		HistoryRentDto rentDto = new HistoryRentDto();
		rentDto.setRentAmount(rentAmount);
		rentDto.setDepositAmount(depositAmount);
		rentDto.setPaidAmount(paidAmount);
		rentDto.setRemainingAmount(remainingAmount);
		return new ResponseEntity<>(rentDto, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> report(RentReportDto dto) {

		Specification<Rent> spec = ReportSpecification.buildSpecification(dto);
		List<Rent> r = rentRepository.findAll(spec);
		List<RentListDto> listDto = r.stream().map(new RentConvertor()).collect(Collectors.toList());
		return Response.build(Code.OK, listDto);
	}

}
