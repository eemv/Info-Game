package aiss.model.twitch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data",
"tag_ids",
"pagination"
})
public class Stream {

@JsonProperty("data")
private Data data;
@JsonProperty("tag_ids")
private List<String> tagIds = null;
@JsonProperty("pagination")
private Pagination pagination;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("data")
public Data getData() {
return data;
}

@JsonProperty("data")
public void setData(Data data) {
this.data = data;
}

@JsonProperty("tag_ids")
public List<String> getTagIds() {
return tagIds;
}

@JsonProperty("tag_ids")
public void setTagIds(List<String> tagIds) {
this.tagIds = tagIds;
}

@JsonProperty("pagination")
public Pagination getPagination() {
return pagination;
}

@JsonProperty("pagination")
public void setPagination(Pagination pagination) {
this.pagination = pagination;
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