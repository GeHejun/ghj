package model;

@Table(name = "ghj_authority_permission")
public class GhjAuthorityPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String type;

    private String url;

    private String percode;

    private Integer parentid;

    private String parentids;

    private String sortstring;

    private Integer available;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return percode
     */
    public String getPercode() {
        return percode;
    }

    /**
     * @param percode
     */
    public void setPercode(String percode) {
        this.percode = percode;
    }

    /**
     * @return parentid
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * @return parentids
     */
    public String getParentids() {
        return parentids;
    }

    /**
     * @param parentids
     */
    public void setParentids(String parentids) {
        this.parentids = parentids;
    }

    /**
     * @return sortstring
     */
    public String getSortstring() {
        return sortstring;
    }

    /**
     * @param sortstring
     */
    public void setSortstring(String sortstring) {
        this.sortstring = sortstring;
    }

    /**
     * @return available
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }
}