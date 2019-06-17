package entity.config;

public class EntityPath {
    //region BaseRest Services

    public static final String GENERATOR = "generator";
    public static final String SEPARATOR = "_";
    public static final String SEQUENCE = "seq";

    //endregion


    public static final String CONTRACT = "contract";
    public static final String CONTRACT_GENERATOR = GENERATOR + SEPARATOR + CONTRACT;
    public static final String CONTRACT_SEQUENCE = CONTRACT + SEPARATOR + SEQUENCE;


    public static final String CONTRACT_DETAIL = "contract_detail";
    public static final String CONTRACT_DETAIL_GENERATOR = GENERATOR + SEPARATOR + CONTRACT_DETAIL;
    public static final String CONTRACT_DETAIL_SEQUENCE = CONTRACT_DETAIL + SEPARATOR + SEQUENCE;


    public static final String USER = "users";
    public static final String USER_GENERATOR = GENERATOR + SEPARATOR + USER;
    public static final String USER_SEQUENCE = USER + SEPARATOR + SEQUENCE;




}
