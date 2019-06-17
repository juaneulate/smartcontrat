package testing;

import lombok.extern.jbosslog.JBossLog;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@JBossLog
public class InfuraService implements Serializable {

    private final int MINIMUM_GAS_LIMIT = 21000;
    private final String PRIVATE_KEY_ROPSTEN = "eddd8ff8105b434887895e9dd5b7f021"; //todo: You have to create an ethereum account on the Ropsten network and put your private key here
    private final String ROPSTEN_INFURA_URL = "https://ropsten.infura.io/v3/eddd8ff8105b434887895e9dd5b7f021"; //todo: You have to register on the Infura website and put your api key here
    private final String CONTRACT_ADDRESS = "0x692a70d2e424a56d2c6c27aa97d1a86395877b3a";


    private Web3j web3j = Web3j.build(new HttpService(ROPSTEN_INFURA_URL));
    private Credentials credentials = Credentials.create(PRIVATE_KEY_ROPSTEN);


    public String readFromContract() {
        String result = "";
        try {
            Greeter greeter = Greeter.load(CONTRACT_ADDRESS, web3j, credentials, new BigInteger("46"), new BigInteger("6465"));
            CompletableFuture<String> greeting = greeter.greet().sendAsync();
            result = greeting.get();
        } catch (Exception e) {
            //log.error("Error reading the smart contract. Error: " + e.getMessage());
        }
        return result;
    }

    public BigInteger writeToContract() {
        String greetingToWrite = "registrar";
        BigInteger result = BigInteger.ZERO;
        try {
            Greeter greeter = Greeter.load(CONTRACT_ADDRESS, web3j, credentials, new BigInteger("46"), new BigInteger("6465"));
            TransactionReceipt transactionReceipt = greeter.changeGreeting(greetingToWrite).sendAsync().get(3, TimeUnit.MINUTES);
            result = transactionReceipt.getGasUsed();
        } catch (Exception e) {
            //log.error("Error during transaction. Error: " + e.getMessage());
        }
        return result;
    }


}