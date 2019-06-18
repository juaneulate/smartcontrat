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


    public static final String LOGIN = "login";
    public static final String LOGIN_GENERATOR = GENERATOR + SEPARATOR + LOGIN;
    public static final String LOGIN_SEQUENCE = LOGIN + SEPARATOR + SEQUENCE;

    public static final String PERSON = "persona";
    public static final String PERSON_GENERATOR = GENERATOR + SEPARATOR + PERSON;
    public static final String PERSON_SEQUENCE = PERSON + SEPARATOR + SEQUENCE;




}
