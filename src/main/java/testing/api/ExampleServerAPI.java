package testing.api;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService("/api")
public interface ExampleServerAPI {

    int add(@JsonRpcParam(value="login") String loginParam, @JsonRpcParam(value="password")String passwordParam);
    int check(@JsonRpcParam(value="login") String loginParam, @JsonRpcParam(value="password") String passwordParam);
    String echo(@JsonRpcParam(value = "message") String message);
}
