package ma.fstt.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Src_main_resources_solidity_MarketPlace_sol_Owned extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03191633179055610149806100326000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80638da5cb5b1461003b578063f2fde38b1461006a575b600080fd5b60005461004e906001600160a01b031681565b6040516001600160a01b03909116815260200160405180910390f35b61007d6100783660046100cd565b61007f565b005b6000546001600160a01b031633146100ab576000546001600160a01b031633146100ab576100ab6100fd565b600080546001600160a01b0319166001600160a01b0392909216919091179055565b6000602082840312156100df57600080fd5b81356001600160a01b03811681146100f657600080fd5b9392505050565b634e487b7160e01b600052600160045260246000fdfea264697066735822122059710d05bd64757c7081a8d54754b4ce341e6a30d416b66b6d6bcaf892a7d89364736f6c634300080b0033";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    @Deprecated
    protected Src_main_resources_solidity_MarketPlace_sol_Owned(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Src_main_resources_solidity_MarketPlace_sol_Owned(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Src_main_resources_solidity_MarketPlace_sol_Owned(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Src_main_resources_solidity_MarketPlace_sol_Owned(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Src_main_resources_solidity_MarketPlace_sol_Owned load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Src_main_resources_solidity_MarketPlace_sol_Owned(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Src_main_resources_solidity_MarketPlace_sol_Owned load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Src_main_resources_solidity_MarketPlace_sol_Owned(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Src_main_resources_solidity_MarketPlace_sol_Owned load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Src_main_resources_solidity_MarketPlace_sol_Owned(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Src_main_resources_solidity_MarketPlace_sol_Owned load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Src_main_resources_solidity_MarketPlace_sol_Owned(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Src_main_resources_solidity_MarketPlace_sol_Owned> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Src_main_resources_solidity_MarketPlace_sol_Owned.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Src_main_resources_solidity_MarketPlace_sol_Owned> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Src_main_resources_solidity_MarketPlace_sol_Owned.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Src_main_resources_solidity_MarketPlace_sol_Owned> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Src_main_resources_solidity_MarketPlace_sol_Owned.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Src_main_resources_solidity_MarketPlace_sol_Owned> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Src_main_resources_solidity_MarketPlace_sol_Owned.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
