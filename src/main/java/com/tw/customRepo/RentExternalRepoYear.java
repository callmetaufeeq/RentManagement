package com.tw.customRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tw.dto.RentDto;
import com.tw.dto.RentSummaryDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Component
public class RentExternalRepoYear {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @SuppressWarnings("unchecked")
//    public List<RentSummaryDTO> findByYear(String year) {
//        String queryString = "SELECT SUM(Rent.paid) AS Paid, SUM(Rent.amount) AS Amount, SUM(Rent.remaining) AS Remaining, Rent.year AS Year, MAX(shop_owner.owner_name) AS Owner_Name, MAX(Shop.shop_name) AS shop_name " +
//                "FROM Rent " +
//                "JOIN shop_owner ON Rent.id = shop_owner.id " +
//                "JOIN Shop ON shop_owner.id = Shop.id " +
//                "WHERE Rent.year = :year " +
//                "GROUP BY Rent.year";
//
//        List<Object[]> resultList = entityManager.createNativeQuery(queryString)
//                .setParameter("year", year)
//                .getResultList();
//
//        List<RentSummaryDTO> rentSummaryDTOList = new ArrayList<>();
//
//        for (Object[] result : resultList) {
//            Double paid = (Double) result[0];
//            Double amount = (Double) result[1];
//            Double remaining = (Double) result[2];
//            String rentYear = (String) result[3];
//            String ownerName = (String) result[4];
//            String shopName = (String) result[5];
//
//            RentSummaryDTO rentSummaryDTO = new RentSummaryDTO(paid, amount, remaining, rentYear, ownerName, shopName);
//            rentSummaryDTOList.add(rentSummaryDTO);
//        }
//
//        return rentSummaryDTOList;
//    }
	@PersistenceContext
	private EntityManager entityManager;

	public List<RentSummaryDTO> findByYear(String year) {
		try {
			
		Query query = entityManager.createNativeQuery(
				"SELECT SUM(Rent.paid) AS Paid, SUM(Rent.amount) AS Amount, SUM(Rent.remaining) AS Remaining, Rent.year AS Year, shop_owner.owner_name AS Owner_Name, Shop.shop_name AS shop_name " +
		                "FROM Rent " +
		                "JOIN shop_owner ON Rent.id = shop_owner.id " +
		                "JOIN Shop ON shop_owner.id = Shop.id " +
		                "WHERE Rent.year = :year " +
		                "GROUP BY Rent.year , shop_owner.owner_name, Shop.shop_name");
		query.setParameter("year", year);

		List<RentSummaryDTO> retList = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = query.getResultList();
		for (Object[] obj : resultList) {
			double paid = (double) obj[0];
			Double amount = (Double) obj[1];
			Double remaining = (Double) obj[2];
            String rentYear = (String) obj[3];
            String ownerName = (String) obj[4];
            String shopName = (String) obj[5];
			RentSummaryDTO dto = new RentSummaryDTO(paid, amount, remaining, rentYear, ownerName, shopName);
			retList.add(dto);
		}

		return retList;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred while fetching rent summaries for the year: " + year);
		}
	}

}
