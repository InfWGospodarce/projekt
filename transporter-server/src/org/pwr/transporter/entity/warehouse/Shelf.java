package org.pwr.transporter.entity.warehouse;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.pwr.transporter.entity.GenericEntity;



/**
 * <pre>
 * Define shelfs on warehouse.
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.5
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "shelf")
public class Shelf extends GenericEntity {

    /**  */
    private static final long serialVersionUID = 2584073916236293060L;


    public Shelf() {
        this.warehouse = new Warehouse();
    }


    // *******************************************************************************************************************************
    // ****** FIELDS
    // *******************************************************************************************************************************

    @ManyToOne(optional = false)
    private Warehouse warehouse;

    @Transient
    private String warehouseId;

    @Column(name = "coordinate_x")
    private String coordinateX;

    @Column(name = "coordinate_y")
    private String coordinateY;

    @Column(name = "coordinate_z")
    private String coordinateZ;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "depth")
    private BigDecimal depth;

    @Column(name = "max_weight")
    private BigDecimal maxWeight;

    @Column(name = "empty")
    private boolean empty;

    @Column(name = "filled")
    private boolean filled;

    @Column(name = "code")
    private String code;


    // *******************************************************************************************************************************
    // ****** GETTERS AND SETTERS
    // *******************************************************************************************************************************
    public Warehouse getWarehouse() {
        return this.warehouse;
    }


    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }


    public String getCoordinateX() {
        return this.coordinateX;
    }


    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }


    public String getCoordinateY() {
        return this.coordinateY;
    }


    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY;
    }


    public String getCoordinateZ() {
        return this.coordinateZ;
    }


    public void setCoordinateZ(String coordinateZ) {
        this.coordinateZ = coordinateZ;
    }


    public BigDecimal getWidth() {
        return this.width;
    }


    public void setWidth(BigDecimal width) {
        this.width = width;
    }


    public BigDecimal getHeight() {
        return this.height;
    }


    public void setHeight(BigDecimal height) {
        this.height = height;
    }


    public BigDecimal getDepth() {
        return this.depth;
    }


    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }


    public BigDecimal getMaxWeight() {
        return this.maxWeight;
    }


    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }


    public boolean isEmpty() {
        return this.empty;
    }


    public void setEmpty(boolean empty) {
        this.empty = empty;
    }


    public boolean isFilled() {
        return this.filled;
    }


    public void setFilled(boolean filled) {
        this.filled = filled;
    }


    public String getCode() {
        return this.code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getWarehouseId() {
        return this.warehouseId;
    }


    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

}
