package aiss.model.igdb;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"abbreviation",
"alternative_name",
"created_at",
"name",
"slug",
"summary",
"updated_at",
"url",
})
public class Platform {

@JsonProperty("id")
private Integer id;
@JsonProperty("abbreviation")
private String abbreviation;
@JsonProperty("alternative_name")
private String alternativeName;
@JsonProperty("created_at")
private Integer createdAt;
@JsonProperty("name")
private String name;
@JsonProperty("slug")
private String slug;
@JsonProperty("summary")
private String summary;
@JsonProperty("updated_at")
private Integer updatedAt;
@JsonProperty("url")
private String url;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("abbreviation")
public String getAbbreviation() {
return abbreviation;
}

@JsonProperty("abbreviation")
public void setAbbreviation(String abbreviation) {
this.abbreviation = abbreviation;
}

@JsonProperty("alternative_name")
public String getAlternativeName() {
return alternativeName;
}

@JsonProperty("alternative_name")
public void setAlternativeName(String alternativeName) {
this.alternativeName = alternativeName;
}

@JsonProperty("created_at")
public Integer getCreatedAt() {
return createdAt;
}

@JsonProperty("created_at")
public void setCreatedAt(Integer createdAt) {
this.createdAt = createdAt;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("slug")
public String getSlug() {
return slug;
}

@JsonProperty("slug")
public void setSlug(String slug) {
this.slug = slug;
}

@JsonProperty("summary")
public String getSummary() {
return summary;
}

@JsonProperty("summary")
public void setSummary(String summary) {
this.summary = summary;
}

@JsonProperty("updated_at")
public Integer getUpdatedAt() {
return updatedAt;
}

@JsonProperty("updated_at")
public void setUpdatedAt(Integer updatedAt) {
this.updatedAt = updatedAt;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}