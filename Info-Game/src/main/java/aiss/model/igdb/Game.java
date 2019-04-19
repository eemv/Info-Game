package aiss.model.igdb;
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
"id",
"age_ratings",
"aggregated_rating",
"cover",
"genres",
"name",
"platforms",
"websites"
})

public class Game {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("age_ratings")
	private List<Integer> ageRatings = null;
	@JsonProperty("aggregated_rating")
	private Double aggregatedRating;
	@JsonProperty("cover")
	private Integer cover;
	@JsonProperty("genres")
	private List<Integer> genres = null;
	@JsonProperty("name")
	private String name;
	@JsonProperty("platforms")
	private List<Integer> platforms = null;
	@JsonProperty("websites")
	private List<Integer> websites = null;
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

	@JsonProperty("age_ratings")
	public List<Integer> getAgeRatings() {
	return ageRatings;
	}

	@JsonProperty("age_ratings")
	public void setAgeRatings(List<Integer> ageRatings) {
	this.ageRatings = ageRatings;
	}

	@JsonProperty("aggregated_rating")
	public Double getAggregatedRating() {
	return aggregatedRating;
	}

	@JsonProperty("aggregated_rating")
	public void setAggregatedRating(Double aggregatedRating) {
	this.aggregatedRating = aggregatedRating;
	}

	@JsonProperty("cover")
	public Integer getCover() {
	return cover;
	}

	@JsonProperty("cover")
	public void setCover(Integer cover) {
	this.cover = cover;
	}

	@JsonProperty("genres")
	public List<Integer> getGenres() {
	return genres;
	}

	@JsonProperty("genres")
	public void setGenres(List<Integer> genres) {
	this.genres = genres;
	}

	@JsonProperty("name")
	public String getName() {
	return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
	this.name = name;
	}

	@JsonProperty("platforms")
	public List<Integer> getPlatforms() {
	return platforms;
	}

	@JsonProperty("platforms")
	public void setPlatforms(List<Integer> platforms) {
	this.platforms = platforms;
	}

	@JsonProperty("websites")
	public List<Integer> getWebsites() {
	return websites;
	}

	@JsonProperty("websites")
	public void setWebsites(List<Integer> websites) {
	this.websites = websites;
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

