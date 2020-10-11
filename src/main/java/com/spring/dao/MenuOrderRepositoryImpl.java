package com.spring.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.MenuOrderItemInfo;
import com.spring.entity.MenuEntity;
import com.spring.entity.MenuOrderEntity;
import com.spring.entity.MenuOrderItemEntity;

@Repository
@Transactional
public class MenuOrderRepositoryImpl extends BaseRepository implements MenuOrderRepository {
	
	private static final Logger LOGGER = Logger.getLogger(MenuOrderRepositoryImpl.class);
	
	public void save(MenuOrderEntity menuOrder) {
		LOGGER.info("Save menu order");
		getSession().save(menuOrder);
		LOGGER.info("Save menu order success");
	}
	
	@SuppressWarnings("unchecked")
	public List<MenuOrderItemInfo> fetchPendingOrder() {
		
		LOGGER.info("Fetch menu order info");
		
		String query = "select moi.order_id "
				+ "        , moi.menu_id "
				+ "        , m.name as menu_name "
				+ "        , c.first_name "
				+ "        , c.last_name "
				+ "        , moi.quantity "
				+ "        , moi.expected_deviler_datetime "
				+ "        , moi.status "
				+ "from menu_order_item moi "
				+ "inner join menu m on m.menu_id = moi.menu_id "
				+ "inner join menu_order mo on mo.order_id = moi.order_id "
				+ "inner join customer c on c.username = mo.username "
				+ "where moi.devilered_datetime is null "
				+ "and moi.status = 'pending' "
				+ "order by moi.expected_deviler_datetime, m.name";
		
		// Using sql query because we have 3 join and will use only one or two column from
		// corresponding tables. This is easier to understand than writing criteria
		// and using HQL which will load entire table. This also demonstrate that we
		// can use normal sql for hibernate as well.
		// As the result object is a result from multiple table, object/relational auto-mapping 
		/// generate exception. So we provide the mapping by ourselves. 
		List<Object[]> objects = getSession().createSQLQuery(query).getResultList();
		List<MenuOrderItemInfo> result = new ArrayList<MenuOrderItemInfo>();
		
		for (Object[] object : objects) {
			MenuOrderItemInfo menu = new MenuOrderItemInfo();
			menu.setOrderId(Integer.parseInt(object[0].toString()));
			menu.setMenuId(Integer.parseInt(object[1].toString()));
			menu.setMenuName(object[2].toString());
			menu.setCustomerFirstName(object[3].toString());
			menu.setCustomerLastName(object[4].toString());
			menu.setQuantity(Integer.parseInt(object[5].toString()));
			menu.setExpectedDeliverDate((Timestamp)object[6]);
			menu.setStatus(object[7].toString());
			result.add(menu);
		}
		
		LOGGER.info("Fetch menu order info success with " + result.size() + " items in list");
		return result;
	}

	@Override
	public MenuOrderItemEntity loadOrderItem(int orderId, int menuId) {
		LOGGER.info("Load menu order item");
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<MenuOrderItemEntity> query = builder.createQuery(MenuOrderItemEntity.class);
		Root<MenuOrderItemEntity> root = query.from(MenuOrderItemEntity.class);
		
		// Add in criteria by menu ID 
		Predicate andClause =  builder.and(
				builder.equal(root.get("orderId"), orderId), 
				builder.equal(root.get("menuId"), menuId));
		
		query.select(root).where(andClause);
		
		// Fetch result
		List<MenuOrderItemEntity> result = getSession().createQuery(query).getResultList();

		LOGGER.info("Load menu order item success");
		return result.get(0);
	}

	@Override
	public void saveOrUpdate(MenuOrderItemEntity menuOrderItem) {
		LOGGER.info("Save menu order");
		getSession().saveOrUpdate(menuOrderItem);
		LOGGER.info("Save menu order success");
	}

}
