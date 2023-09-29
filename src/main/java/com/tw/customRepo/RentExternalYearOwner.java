package com.tw.customRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tw.dto.RentYearOwnerId;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Component
public class RentExternalYearOwner {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<RentYearOwnerId> findByShopOwnerIdAndYear(Long id, String year) {
		Query query = entityManager.createNativeQuery(
				"SELECT r FROM Rent r JOIN r.shopOwner s WHERE s.id = :shopOwnerId AND r.year = :year");

		query.setParameter("id", id);
		query.setParameter("year", year);

		List<RentYearOwnerId> retList = new ArrayList<>();
		List<Object> l = query.getResultList();
		Iterator<Object> itr = l.iterator();
		
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			double amount = (double) obj[0];
			double paidAmount = (double) obj[1];
			double remainingAmount = (double) obj[2];
			RentYearOwnerId dto = new RentYearOwnerId(amount, paidAmount, remainingAmount);
			retList.add(dto);
		}

		return retList;
	}

}
