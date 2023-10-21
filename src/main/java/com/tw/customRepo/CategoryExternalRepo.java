/*
 * package com.tw.customRepo;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import com.tw.dto.CategoryDto;
 * 
 * public class CategoryExternalRepo { @SuppressWarnings("unchecked") public
 * List<CategoryDto> findByCategoryId(Long id) { String queryString =
 * "SELECT SUM(Rent.paid) AS Paid, SUM(Rent.amount) AS Amount, SUM(Rent.remaining) AS Remaining, MAX(shop_owner.owner_name) AS Owner_Name, MAX(Shop.shop_name) AS shop_name "
 * + "FROM Category " + "JOIN shop_owner ON Category.id = shop_owner.id " +
 * "JOIN Shop ON shop_owner.id = Shop.id " + "WHERE Category.id = :id ";
 * 
 * List<Object[]> resultList = entityManager.createNativeQuery(queryString)
 * .setParameter("id", id) .getResultList();
 * 
 * List<CategoryDto> categorySummary = new ArrayList<>();
 * 
 * for (Object[] result : resultList) { String categoryName = (String)
 * result[0]; String ownerName = (String) result[1]; String shopName = (String)
 * result[2]; Double amount = (Double) result[3]; Double paid = (Double)
 * result[4]; Double remaining = (Double) result[5];
 * 
 * RentSummaryDTO rentSummaryDTO = new RentSummaryDTO(paid, amount, remaining,
 * rentYear, ownerName, shopName); rentSummaryDTOList.add(rentSummaryDTO);
 * 
 * 
 * }
 * 
 * 
 * 
 *     }
 * 
 * }
 */