package com.tw.customRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
import com.tw.dto.RentDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Component
public class RentExternalRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<RentDto> findSum(Long id, String year) {
		Query query = entityManager.createNativeQuery(
				" SELECT SUM(r.paid) AS paid, r.year As year, r.payment_type As paymentType " + "    FROM rent r "
						+ "    WHERE r.year=:year AND r.shop_owner_id=:id " + "    GROUP BY r.payment_type, r.year ");

		query.setParameter("id", id);
		query.setParameter("year", year);

		List<RentDto> retList = new ArrayList<>();
		List<Object> l = query.getResultList();
		Iterator<Object> itr = l.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			double paid = (double) obj[0];
			String resyear = (String) obj[1];
			String payTyp = (String) obj[2];
			RentDto dto = new RentDto(paid, resyear, payTyp);
			retList.add(dto);
		}

		return retList;
	}

}
