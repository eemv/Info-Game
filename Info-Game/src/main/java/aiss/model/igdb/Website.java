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
"game",
"trusted",
"url"
})
public class Website {

@JsonProperty("id")
private Integer id;
@JsonProperty("category")
private Integer category;
@JsonProperty("game")
private Integer game;
@JsonProperty("trusted")
private Boolean trusted;
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

@JsonProperty("category")
public Integer getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(Integer category) {
this.category = category;
}

@JsonProperty("game")
public Integer getGame() {
return game;
}

@JsonProperty("game")
public void setGame(Integer game) {
this.game = game;
}

@JsonProperty("trusted")
public Boolean getTrusted() {
return trusted;
}

@JsonProperty("trusted")
public void setTrusted(Boolean trusted) {
this.trusted = trusted;
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