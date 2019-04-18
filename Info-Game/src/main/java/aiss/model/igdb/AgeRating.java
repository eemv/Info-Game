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
"category",
"rating"
})
public class AgeRating {

@JsonProperty("id")
private Integer id;
@JsonProperty("category")
private Integer category;
@JsonProperty("rating")
private Integer rating;
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

@JsonProperty("category")
public Integer getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(Integer category) {
this.category = category;
}

@JsonProperty("rating")
public Integer getRating() {
return rating;
}

@JsonProperty("rating")
public void setRating(Integer rating) {
this.rating = rating;
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