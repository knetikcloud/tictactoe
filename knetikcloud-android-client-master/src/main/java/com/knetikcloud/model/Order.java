/**
 * Knetik Platform API Documentation latest 
 * This is the spec for the Knetik API.  Use this in conjunction with the documentation found at https://knetikcloud.com
 *
 * OpenAPI spec version: latest 
 * Contact: support@knetik.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.knetikcloud.model;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Order {
  
  @SerializedName("ascending")
  private Boolean ascending = null;
  public enum DirectionEnum {
     ASC,  DESC, 
  };
  @SerializedName("direction")
  private DirectionEnum direction = null;
  @SerializedName("ignore_case")
  private Boolean ignoreCase = null;
  public enum NullHandlingEnum {
     NATIVE,  NULLS_FIRST,  NULLS_LAST, 
  };
  @SerializedName("null_handling")
  private NullHandlingEnum nullHandling = null;
  @SerializedName("property")
  private String property = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getAscending() {
    return ascending;
  }
  public void setAscending(Boolean ascending) {
    this.ascending = ascending;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public DirectionEnum getDirection() {
    return direction;
  }
  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getIgnoreCase() {
    return ignoreCase;
  }
  public void setIgnoreCase(Boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public NullHandlingEnum getNullHandling() {
    return nullHandling;
  }
  public void setNullHandling(NullHandlingEnum nullHandling) {
    this.nullHandling = nullHandling;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getProperty() {
    return property;
  }
  public void setProperty(String property) {
    this.property = property;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return (this.ascending == null ? order.ascending == null : this.ascending.equals(order.ascending)) &&
        (this.direction == null ? order.direction == null : this.direction.equals(order.direction)) &&
        (this.ignoreCase == null ? order.ignoreCase == null : this.ignoreCase.equals(order.ignoreCase)) &&
        (this.nullHandling == null ? order.nullHandling == null : this.nullHandling.equals(order.nullHandling)) &&
        (this.property == null ? order.property == null : this.property.equals(order.property));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.ascending == null ? 0: this.ascending.hashCode());
    result = 31 * result + (this.direction == null ? 0: this.direction.hashCode());
    result = 31 * result + (this.ignoreCase == null ? 0: this.ignoreCase.hashCode());
    result = 31 * result + (this.nullHandling == null ? 0: this.nullHandling.hashCode());
    result = 31 * result + (this.property == null ? 0: this.property.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("  ascending: ").append(ascending).append("\n");
    sb.append("  direction: ").append(direction).append("\n");
    sb.append("  ignoreCase: ").append(ignoreCase).append("\n");
    sb.append("  nullHandling: ").append(nullHandling).append("\n");
    sb.append("  property: ").append(property).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}