package org.pwr.transporter.server.web.services.warehouse;


import java.util.List;
import java.util.Map;

import org.pwr.transporter.entity.warehouse.Shelf;
import org.pwr.transporter.server.business.warehouse.ShelfLogic;
import org.pwr.transporter.server.business.warehouse.WarehouseLogic;
import org.pwr.transporter.server.core.hb.criteria.Criteria;
import org.pwr.transporter.server.web.services.IService;
import org.springframework.beans.factory.annotation.Autowired;


public class ShelfService implements IService {

	@Autowired
	ShelfLogic shelfLogic;

	@Autowired
	WarehouseLogic warehouseLogic;

	public Shelf getByID( Long id ) {
		Shelf shelf = this.shelfLogic.getByID(id);
		if ( shelf.getWarehouse() != null ) {
			shelf.setWarehouseId(shelf.getWarehouse().getId().toString());
		}
		return shelf;
	}

	public Long insert( Shelf entity ) {
		entity.setWarehouse(warehouseLogic.getByID(Long.valueOf(entity.getWarehouseId())));
		return this.shelfLogic.insert(entity);
	}

	public void update( Shelf entity ) {
		entity.setWarehouse(warehouseLogic.getByID(Long.valueOf(entity.getWarehouseId())));
		this.shelfLogic.update(entity);
	}

	public void delete( Shelf entity ) {
		this.shelfLogic.delete(entity);
	}

	public void deleteById( Long id ) {
		this.shelfLogic.deleteById(id);
	}

	@SuppressWarnings("unchecked")
	public List<Shelf> getListRest( int amount, int fromRow ) {
		return this.shelfLogic.getListRest(amount, fromRow);
	}

	public long count() {
		return this.shelfLogic.count();
	}

	public long count( Criteria criteria ) {
		return this.shelfLogic.count(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<Shelf> getListRestCrit( int amount, int fromRow, Criteria criteria ) {
		return this.shelfLogic.getListRestCrit(amount, fromRow, criteria);
	}

	public List<Shelf> search( Map<String, Object> parameterMap ) {
		return this.shelfLogic.search(parameterMap);
	}

}
