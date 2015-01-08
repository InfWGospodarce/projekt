package org.pwr.transporter.server.dao.impl;


import org.pwr.transporter.entity.Generic;



public class ObjectDAOImpl extends GenericDAOImpl<Generic> {

    public ObjectDAOImpl() {
        setEntityClass(Generic.class);
    }


    public Generic getEntity(Long id) {
        return getByID(id);
    }

}
