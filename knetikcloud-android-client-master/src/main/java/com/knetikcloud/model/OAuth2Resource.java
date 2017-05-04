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
public class OAuth2Resource {
  
  @SerializedName("access_token")
  private String accessToken = null;
  @SerializedName("expires_in")
  private String expiresIn = null;
  @SerializedName("scope")
  private String scope = null;
  @SerializedName("token_type")
  private String tokenType = null;

  /**
   * The access token issued by the authorization server
   **/
  @ApiModelProperty(value = "The access token issued by the authorization server")
  public String getAccessToken() {
    return accessToken;
  }
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  /**
   * The lifetime in seconds of the access token
   **/
  @ApiModelProperty(value = "The lifetime in seconds of the access token")
  public String getExpiresIn() {
    return expiresIn;
  }
  public void setExpiresIn(String expiresIn) {
    this.expiresIn = expiresIn;
  }

  /**
   * The scope of the access token. Currently these values can be ignored, as security defaults to roles and permissions
   **/
  @ApiModelProperty(value = "The scope of the access token. Currently these values can be ignored, as security defaults to roles and permissions")
  public String getScope() {
    return scope;
  }
  public void setScope(String scope) {
    this.scope = scope;
  }

  /**
   * The type of the token issued
   **/
  @ApiModelProperty(value = "The type of the token issued")
  public String getTokenType() {
    return tokenType;
  }
  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OAuth2Resource oAuth2Resource = (OAuth2Resource) o;
    return (this.accessToken == null ? oAuth2Resource.accessToken == null : this.accessToken.equals(oAuth2Resource.accessToken)) &&
        (this.expiresIn == null ? oAuth2Resource.expiresIn == null : this.expiresIn.equals(oAuth2Resource.expiresIn)) &&
        (this.scope == null ? oAuth2Resource.scope == null : this.scope.equals(oAuth2Resource.scope)) &&
        (this.tokenType == null ? oAuth2Resource.tokenType == null : this.tokenType.equals(oAuth2Resource.tokenType));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.accessToken == null ? 0: this.accessToken.hashCode());
    result = 31 * result + (this.expiresIn == null ? 0: this.expiresIn.hashCode());
    result = 31 * result + (this.scope == null ? 0: this.scope.hashCode());
    result = 31 * result + (this.tokenType == null ? 0: this.tokenType.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OAuth2Resource {\n");
    
    sb.append("  accessToken: ").append(accessToken).append("\n");
    sb.append("  expiresIn: ").append(expiresIn).append("\n");
    sb.append("  scope: ").append(scope).append("\n");
    sb.append("  tokenType: ").append(tokenType).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}