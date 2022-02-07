package ma.fstt.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
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
public class Src_main_resources_solidity_MarketPlace_sol_MarketPlace extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03191633179055610c90806100326000396000f3fe60806040526004361061007b5760003560e01c80638da5cb5b1161004e5780638da5cb5b146100f357806397aedaeb1461012b578063f2fde38b1461015f578063fd7d93961461017f57600080fd5b80631cc4baa81461008057806341c0e1b5146100955780637f6be3da146100aa57806389da85d3146100d5575b600080fd5b61009361008e366004610865565b61019f565b005b3480156100a157600080fd5b5061009361027f565b3480156100b657600080fd5b506100bf6102b9565b6040516100cc919061087e565b60405180910390f35b3480156100e157600080fd5b506002546040519081526020016100cc565b3480156100ff57600080fd5b50600054610113906001600160a01b031681565b6040516001600160a01b0390911681526020016100cc565b34801561013757600080fd5b5061014b610146366004610865565b610441565b6040516100cc98979695949392919061090f565b34801561016b57600080fd5b5061009361017a366004610982565b610628565b34801561018b57600080fd5b5061009361019a366004610a55565b610676565b6000600254116101ae57600080fd5b6000811180156101c057506002548111155b6101c957600080fd5b600081815260016020526040902060028101546001600160a01b0316156101ef57600080fd5b60018101546001600160a01b031633141561020957600080fd5b6002810180546001600160a01b031916339081179091556001820154600683015460078401546040516001600160a01b03939093169286927f456406853bd2e9f1737a6312395fabb9ebb17c2b706af24889dab3068ab2fba5926102739260038901929190610b2a565b60405180910390a45050565b6000546001600160a01b031633146102ab576000546001600160a01b031633146102ab576102ab610be0565b6000546001600160a01b0316ff5b6060600254600014156102d9575060408051600081526020810190915290565b600060025467ffffffffffffffff8111156102f6576102f66109b2565b60405190808252806020026020018201604052801561031f578160200160208202803683370190505b509050600060015b600254811161039d576000818152600160205260409020600201546001600160a01b031661038b57600081815260016020526040902054835184908490811061037257610372610bf6565b60209081029190910101528161038781610c0c565b9250505b8061039581610c0c565b915050610327565b5060008167ffffffffffffffff8111156103b9576103b96109b2565b6040519080825280602002602001820160405280156103e2578160200160208202803683370190505b50905060005b828110156104395783818151811061040257610402610bf6565b602002602001015182828151811061041c5761041c610bf6565b60209081029190910101528061043181610c0c565b9150506103e8565b509392505050565b600160208190526000918252604090912080549181015460028201546003830180546001600160a01b0393841694929093169261047d90610aef565b80601f01602080910402602001604051908101604052809291908181526020018280546104a990610aef565b80156104f65780601f106104cb576101008083540402835291602001916104f6565b820191906000526020600020905b8154815290600101906020018083116104d957829003601f168201915b50505050509080600401805461050b90610aef565b80601f016020809104026020016040519081016040528092919081815260200182805461053790610aef565b80156105845780601f1061055957610100808354040283529160200191610584565b820191906000526020600020905b81548152906001019060200180831161056757829003601f168201915b50505050509080600501805461059990610aef565b80601f01602080910402602001604051908101604052809291908181526020018280546105c590610aef565b80156106125780601f106105e757610100808354040283529160200191610612565b820191906000526020600020905b8154815290600101906020018083116105f557829003601f168201915b5050505050908060060154908060070154905088565b6000546001600160a01b03163314610654576000546001600160a01b0316331461065457610654610be0565b600080546001600160a01b0319166001600160a01b0392909216919091179055565b6002805490600061068683610c0c565b90915550506040805161010081018252600280548083523360208085019182526000858701818152606087018d8152608088018d905260a088018c905260c088018b905260e088018a905294825260018084529790912086518155925196830180546001600160a01b039889166001600160a01b031991821617909155905194830180549590971694169390931790945551805192939261072d92600385019201906107cc565b50608082015180516107499160048401916020909101906107cc565b5060a082015180516107659160058401916020909101906107cc565b5060c0820151816006015560e08201518160070155905050336001600160a01b03166002547fedaf7146ac6ae4eacdb580f9716996bc0531a366e344966b1b833b67f86f14b88785856040516107bd93929190610c35565b60405180910390a35050505050565b8280546107d890610aef565b90600052602060002090601f0160209004810192826107fa5760008555610840565b82601f1061081357805160ff1916838001178555610840565b82800160010185558215610840579182015b82811115610840578251825591602001919060010190610825565b5061084c929150610850565b5090565b5b8082111561084c5760008155600101610851565b60006020828403121561087757600080fd5b5035919050565b6020808252825182820181905260009190848201906040850190845b818110156108b65783518352928401929184019160010161089a565b50909695505050505050565b6000815180845260005b818110156108e8576020818501810151868301820152016108cc565b818111156108fa576000602083870101525b50601f01601f19169290920160200192915050565b8881526001600160a01b0388811660208301528716604082015261010060608201819052600090610942838201896108c2565b9050828103608084015261095681886108c2565b905082810360a084015261096a81876108c2565b60c0840195909552505060e001529695505050505050565b60006020828403121561099457600080fd5b81356001600160a01b03811681146109ab57600080fd5b9392505050565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126109d957600080fd5b813567ffffffffffffffff808211156109f4576109f46109b2565b604051601f8301601f19908116603f01168101908282118183101715610a1c57610a1c6109b2565b81604052838152866020858801011115610a3557600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080600060a08688031215610a6d57600080fd5b853567ffffffffffffffff80821115610a8557600080fd5b610a9189838a016109c8565b96506020880135915080821115610aa757600080fd5b610ab389838a016109c8565b95506040880135915080821115610ac957600080fd5b50610ad6888289016109c8565b9598949750949560608101359550608001359392505050565b600181811c90821680610b0357607f821691505b60208210811415610b2457634e487b7160e01b600052602260045260246000fd5b50919050565b60608152600080855481600182811c915080831680610b4a57607f831692505b6020808410821415610b6a57634e487b7160e01b86526022600452602486fd5b6060880184905260808801828015610b895760018114610b9a57610bc5565b60ff19871682528282019750610bc5565b60008d81526020902060005b87811015610bbf57815484820152908601908401610ba6565b83019850505b50508701989098525050506040909201929092529392505050565b634e487b7160e01b600052600160045260246000fd5b634e487b7160e01b600052603260045260246000fd5b6000600019821415610c2e57634e487b7160e01b600052601160045260246000fd5b5060010190565b606081526000610c4860608301866108c2565b6020830194909452506040015291905056fea26469706673582212200765b6e9db41d6773c08442892f30e74f32da1a8dca6d2706d72272d3ee3f3e164736f6c634300080b0033";

    public static final String FUNC_BUYARTICLE = "buyArticle";

    public static final String FUNC_GETARTICLESFORSALE = "getArticlesForSale";

    public static final String FUNC_GETNUMBEROFARTICLES = "getNumberOfArticles";

    public static final String FUNC_IMMOBILIERS = "immobiliers";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SELLIMMOBILIER = "sellImmobilier";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event BUYIMMOBILIEREVENT_EVENT = new Event("buyImmobilierEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SELLIMMOBILIEREVENT_EVENT = new Event("sellImmobilierEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Src_main_resources_solidity_MarketPlace_sol_MarketPlace(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Src_main_resources_solidity_MarketPlace_sol_MarketPlace(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Src_main_resources_solidity_MarketPlace_sol_MarketPlace(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Src_main_resources_solidity_MarketPlace_sol_MarketPlace(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<BuyImmobilierEventEventResponse> getBuyImmobilierEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BUYIMMOBILIEREVENT_EVENT, transactionReceipt);
        ArrayList<BuyImmobilierEventEventResponse> responses = new ArrayList<BuyImmobilierEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BuyImmobilierEventEventResponse typedResponse = new BuyImmobilierEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._seller = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._buyer = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse._name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._price = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._surface = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BuyImmobilierEventEventResponse> buyImmobilierEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BuyImmobilierEventEventResponse>() {
            @Override
            public BuyImmobilierEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BUYIMMOBILIEREVENT_EVENT, log);
                BuyImmobilierEventEventResponse typedResponse = new BuyImmobilierEventEventResponse();
                typedResponse.log = log;
                typedResponse._id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._buyer = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse._name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._price = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._surface = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BuyImmobilierEventEventResponse> buyImmobilierEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BUYIMMOBILIEREVENT_EVENT));
        return buyImmobilierEventEventFlowable(filter);
    }

    public List<SellImmobilierEventEventResponse> getSellImmobilierEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SELLIMMOBILIEREVENT_EVENT, transactionReceipt);
        ArrayList<SellImmobilierEventEventResponse> responses = new ArrayList<SellImmobilierEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SellImmobilierEventEventResponse typedResponse = new SellImmobilierEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._seller = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._price = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._surface = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SellImmobilierEventEventResponse> sellImmobilierEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SellImmobilierEventEventResponse>() {
            @Override
            public SellImmobilierEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SELLIMMOBILIEREVENT_EVENT, log);
                SellImmobilierEventEventResponse typedResponse = new SellImmobilierEventEventResponse();
                typedResponse.log = log;
                typedResponse._id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._price = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._surface = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SellImmobilierEventEventResponse> sellImmobilierEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SELLIMMOBILIEREVENT_EVENT));
        return sellImmobilierEventEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> buyArticle(BigInteger _id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BUYARTICLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getArticlesForSale() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETARTICLESFORSALE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getNumberOfArticles() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNUMBEROFARTICLES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple8<BigInteger, String, String, String, String, String, BigInteger, BigInteger>> immobiliers(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_IMMOBILIERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple8<BigInteger, String, String, String, String, String, BigInteger, BigInteger>>(function,
                new Callable<Tuple8<BigInteger, String, String, String, String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple8<BigInteger, String, String, String, String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, String, String, String, String, String, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> kill() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> sellImmobilier(String _name, String _description, String _localisation, BigInteger _price, BigInteger _surface) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SELLIMMOBILIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.Utf8String(_localisation), 
                new org.web3j.abi.datatypes.generated.Uint256(_price), 
                new org.web3j.abi.datatypes.generated.Uint256(_surface)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Src_main_resources_solidity_MarketPlace_sol_MarketPlace load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Src_main_resources_solidity_MarketPlace_sol_MarketPlace(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Src_main_resources_solidity_MarketPlace_sol_MarketPlace load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Src_main_resources_solidity_MarketPlace_sol_MarketPlace(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Src_main_resources_solidity_MarketPlace_sol_MarketPlace load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Src_main_resources_solidity_MarketPlace_sol_MarketPlace(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Src_main_resources_solidity_MarketPlace_sol_MarketPlace load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Src_main_resources_solidity_MarketPlace_sol_MarketPlace(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Src_main_resources_solidity_MarketPlace_sol_MarketPlace> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Src_main_resources_solidity_MarketPlace_sol_MarketPlace.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Src_main_resources_solidity_MarketPlace_sol_MarketPlace> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Src_main_resources_solidity_MarketPlace_sol_MarketPlace.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Src_main_resources_solidity_MarketPlace_sol_MarketPlace> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Src_main_resources_solidity_MarketPlace_sol_MarketPlace.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Src_main_resources_solidity_MarketPlace_sol_MarketPlace> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Src_main_resources_solidity_MarketPlace_sol_MarketPlace.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class BuyImmobilierEventEventResponse extends BaseEventResponse {
        public BigInteger _id;

        public String _seller;

        public String _buyer;

        public String _name;

        public BigInteger _price;

        public BigInteger _surface;
    }

    public static class SellImmobilierEventEventResponse extends BaseEventResponse {
        public BigInteger _id;

        public String _seller;

        public String _name;

        public BigInteger _price;

        public BigInteger _surface;
    }
}
