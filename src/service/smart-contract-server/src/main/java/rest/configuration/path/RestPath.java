package rest.configuration.path;

public final class RestPath {
    //region Configuration

    public static final String SEPARATOR = "/";
    public static final String BASE_REST = "rest";

    //endregion Configuration

    //region BaseRest Services

    public static final String REST_UTIL = "util";
    public static final String REST_CONTRACT = "contract";
    public static final String REST_INFURA = "infura";
    public static final String REST_LOGIN = "login";
    public static final String REST_PERSON = "person";

    //endregion

    //region Utils

    public static final String TEST_SQL = "test-sql";
    public static final String TEST_GET = "test-get-service";
    public static final String TEST_GET_SERVICE_WITH_PARAM = "test-get-service-with-param";
    public static final String TEST_POST = "testing-post-service";
    public static final String TEST_POST_WITH_DTO = "testing-post-with-dto";
    public static final String TEST_PUT = "test-put-service";
    public static final String TEST_POST_OWNER_SAVE = "owner-save";
    public static final String TEST_POST_TENANT_SAVE = "tenant-save";
    public static final String TEST_GET_OWNER = "get-owner";
    public static final String TEST_GET_TENANT = "get-tenant";

    //endregion

    //region Common Paths

    public static final String LIST = "list";
    public static final String LIST_OWNER = "list-owner";
    public static final String LIST_TENANT = "list-tenant";
    public static final String SAVE = "save";
    public static final String CREATE = "create";
    public static final String CONFIRM = "confirm";
    public static final String REGISTER = "register";
    public static final String SYNCHRONIZE = "synchronize";
    public static final String SYNCHRONIZE_CONFIRM = "synchronize-confirm";
    public static final String AUTHENTICATE = "authenticate";
    public static final String AUTH = "auth";
    public static final String ALL = "all";
    public static final String VALIDATE = "validate";

    //endregion


    //region Commons Params

    public static final String CODE = "code";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public static final String AGE = "age";
    public static final String GET_PERSON = "get-person";
    public static final String GET_CONTRACT = "get-contract";
    public static final String CONTRACT_ID = "contract_id";




    //endregion Commons Params

}
