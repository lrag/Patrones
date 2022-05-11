package com.curso.modelo.contrato.proxy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
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
public class TrazaElJamon extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b5060408051808201825260008082528251602081810190945281815283830190815281805290835281517fad3228b676f7d3cd4284a5443f17f1962b36e491b30a40b2405849e597ba5fb5908155905180519293919262000096927fad3228b676f7d3cd4284a5443f17f1962b36e491b30a40b2405849e597ba5fb69201906200076b565b505060408051808201825260018082528251808401909352600683526546697374726f60d01b602084810191909152808301938452600091825290815281517fada5013122d395ba3c54772283fb069b10426056ef8ca54750cb9bb552a59e7d9081559251805192945062000132927fada5013122d395ba3c54772283fb069b10426056ef8ca54750cb9bb552a59e7e9291909101906200076b565b505060408051808201825260028082528251808401909352600683526546697374726160d01b602084810191909152808301938452600091825290815281517fabbb5caa7dda850e60932de0934eb1f9d0f59695050f761dc64e443e5030a56990815592518051929450620001ce927fabbb5caa7dda850e60932de0934eb1f9d0f59695050f761dc64e443e5030a56a9291909101906200076b565b50506040805180820182526000808252825160208181019094528181528383019081529080526001835281517fa6eef7e35abe7026729641147f7915573c7e97b47efa546f5f6e3230263bcb4990815590518051929450909262000258927fa6eef7e35abe7026729641147f7915573c7e97b47efa546f5f6e3230263bcb4a92909101906200076b565b50506040805180820182526001808252825180840190935260098352680a6e45c40a6dad2e8d60bb1b602084810191909152808301938452600082905290815281517fcc69885fda6bcc1a4ace058b4a62bf5e179ea78fd58a1ccd71c22cc9b688792f90815592518051929450620002f7927fcc69885fda6bcc1a4ace058b4a62bf5e179ea78fd58a1ccd71c22cc9b68879309291909101906200076b565b50506040805180820182526000808252825160208181019094528181528383019081529080526002835281517fac33ff75c19e70fe83507db0d683fd3465c996598dc972688b7ace676c89077b90815590518051929450909262000381927fac33ff75c19e70fe83507db0d683fd3465c996598dc972688b7ace676c89077c92909101906200076b565b505060408051808201825260018082528251808401909352601583527f4d6174616465726f2064652053616c616d616e636100000000000000000000006020848101919091528083019384526000919091526002815281517fe90b7bceb6e7df5418fb78d8ee546e97c83a08bbccc01a0644d599ccd2a7c2e09081559251805192945062000436927fe90b7bceb6e7df5418fb78d8ee546e97c83a08bbccc01a0644d599ccd2a7c2e19291909101906200076b565b50506040805180820182526002808252825180840190935260128352714d6174616465726f20646520c38176696c6160701b602084810191909152808301938452600082905290815281517f679795a0195a1b76cdebb7c51d74e058aee92919b8c3389af86ef24535e8a28c90815592518051929450620004de927f679795a0195a1b76cdebb7c51d74e058aee92919b8c3389af86ef24535e8a28d9291909101906200076b565b50506040805160e08101825260018082526000602080840182815284860183815286518088019097526002875261523160f01b87840152606086019687526080860185905260a0860184905260c08601849052939092526003815283517fa15bc60c955c405d20d9149c709e2460f1c2d9a497496a7f46004d1772c3054c90815591517fa15bc60c955c405d20d9149c709e2460f1c2d9a497496a7f46004d1772c3054d8054945115156101000261ff00199215159290921661ffff19909516949094171790925592518051929450620005df927fa15bc60c955c405d20d9149c709e2460f1c2d9a497496a7f46004d1772c3054e9291909101906200076b565b5060808281015160038084019190915560a080850151600485015560c0948501516005909401939093556040805160e081018252600280825260006020808401828152848601838152865180880190975284875261291960f11b87840152606086019687529785018490529784018290529783018190525291855281517fc3a24b0501bd2c13a7e57f2db4369ec4c223447539fc0724a9d55ac4a06ebd4d90815593517fc3a24b0501bd2c13a7e57f2db4369ec4c223447539fc0724a9d55ac4a06ebd4e8054945115156101000261ff00199215159290921661ffff199095169490941717909255905180519193620006fe927fc3a24b0501bd2c13a7e57f2db4369ec4c223447539fc0724a9d55ac4a06ebd4f92909101906200076b565b506080820151600382015560a082015160048083019190915560c09092015160059091015580546001818101835560008390527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b918201819055825490810190925560029101556200084d565b828054620007799062000811565b90600052602060002090601f0160209004810192826200079d5760008555620007e8565b82601f10620007b857805160ff1916838001178555620007e8565b82800160010185558215620007e8579182015b82811115620007e8578251825591602001919060010190620007cb565b50620007f6929150620007fa565b5090565b5b80821115620007f65760008155600101620007fb565b600181811c908216806200082657607f821691505b6020821081036200084757634e487b7160e01b600052602260045260246000fd5b50919050565b6107c4806200085d6000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80630e4ce13214610051578063a0c3f78c1461008a578063b08a5b0b146100c1578063dfa666ec146100d4575b600080fd5b61008861005f366004610593565b6000918252600360205260409091206005810191909155600101805461ff001916610100179055565b005b610088610098366004610593565b60009182526003602052604090912060048101919091556001908101805460ff19169091179055565b6100886100cf3660046105cb565b610101565b6100e76100e236600461068f565b6101e8565b6040516100f89594939291906106f5565b60405180910390f35b6040805160e08101825284815260006020808301828152838501838152606085018781526080860189905260a0860185905260c086018590528985526003845295909320845181559051600182018054945115156101000261ff00199215159290921661ffff199095169490941717909255925180519293919261018b92600285019201906104fa565b506080820151600382015560a082015160048083019190915560c09092015160059091015580546001810182556000919091527f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01929092555050565b6000818152600360209081526040808320815160e08101835281548152600182015460ff8082161515958301959095526101009004909316151591830191909152600281018054606093849384938493889392918386019161024990610754565b80601f016020809104026020016040519081016040528092919081815260200182805461027590610754565b80156102c25780601f10610297576101008083540402835291602001916102c2565b820191906000526020600020905b8154815290600101906020018083116102a557829003601f168201915b50505050508152602001600382015481526020016004820154815260200160058201548152505090508060000151816060015160008084608001518152602001908152602001600020600101600160008560a001518152602001908152602001600020600101600260008660c00151815260200190815260200160002060010182805461034e90610754565b80601f016020809104026020016040519081016040528092919081815260200182805461037a90610754565b80156103c75780601f1061039c576101008083540402835291602001916103c7565b820191906000526020600020905b8154815290600101906020018083116103aa57829003601f168201915b505050505092508180546103da90610754565b80601f016020809104026020016040519081016040528092919081815260200182805461040690610754565b80156104535780601f1061042857610100808354040283529160200191610453565b820191906000526020600020905b81548152906001019060200180831161043657829003601f168201915b5050505050915080805461046690610754565b80601f016020809104026020016040519081016040528092919081815260200182805461049290610754565b80156104df5780601f106104b4576101008083540402835291602001916104df565b820191906000526020600020905b8154815290600101906020018083116104c257829003601f168201915b50505050509050955095509550955095505091939590929450565b82805461050690610754565b90600052602060002090601f016020900481019282610528576000855561056e565b82601f1061054157805160ff191683800117855561056e565b8280016001018555821561056e579182015b8281111561056e578251825591602001919060010190610553565b5061057a92915061057e565b5090565b5b8082111561057a576000815560010161057f565b600080604083850312156105a657600080fd5b50508035926020909101359150565b634e487b7160e01b600052604160045260246000fd5b6000806000606084860312156105e057600080fd5b8335925060208401359150604084013567ffffffffffffffff8082111561060657600080fd5b818601915086601f83011261061a57600080fd5b81358181111561062c5761062c6105b5565b604051601f8201601f19908116603f01168101908382118183101715610654576106546105b5565b8160405282815289602084870101111561066d57600080fd5b8260208601602083013760006020848301015280955050505050509250925092565b6000602082840312156106a157600080fd5b5035919050565b6000815180845260005b818110156106ce576020818501810151868301820152016106b2565b818111156106e0576000602083870101525b50601f01601f19169290920160200192915050565b85815260a06020820152600061070e60a08301876106a8565b828103604084015261072081876106a8565b9050828103606084015261073481866106a8565b9050828103608084015261074881856106a8565b98975050505050505050565b600181811c9082168061076857607f821691505b60208210810361078857634e487b7160e01b600052602260045260246000fd5b5091905056fea264697066735822122006926fb26aacb930dd9e4d9527284021167c361bf91965bde864c002946ad98e64736f6c634300080d0033";

    public static final String FUNC_BUSCARCERDO = "buscarCerdo";

    public static final String FUNC_CREARCERDO = "crearCerdo";

    public static final String FUNC_SACRIFICARCERDO = "sacrificarCerdo";

    public static final String FUNC_VACUNARCERDO = "vacunarCerdo";

    @Deprecated
    protected TrazaElJamon(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TrazaElJamon(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TrazaElJamon(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TrazaElJamon(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, String, String, String, String>> buscarCerdo(BigInteger _idCerdo) {
        final Function function = new Function(FUNC_BUSCARCERDO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idCerdo)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, String, String, String, String>>(function,
                new Callable<Tuple5<BigInteger, String, String, String, String>>() {
                    @Override
                    public Tuple5<BigInteger, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, String, String, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> crearCerdo(BigInteger _idCerdo, BigInteger _idGranjero, String _raza) {
        final Function function = new Function(
                FUNC_CREARCERDO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idCerdo), 
                new org.web3j.abi.datatypes.generated.Uint256(_idGranjero), 
                new org.web3j.abi.datatypes.Utf8String(_raza)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sacrificarCerdo(BigInteger _idCerdo, BigInteger _idMatadero) {
        final Function function = new Function(
                FUNC_SACRIFICARCERDO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idCerdo), 
                new org.web3j.abi.datatypes.generated.Uint256(_idMatadero)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> vacunarCerdo(BigInteger _idCerdo, BigInteger _idVeterinario) {
        final Function function = new Function(
                FUNC_VACUNARCERDO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idCerdo), 
                new org.web3j.abi.datatypes.generated.Uint256(_idVeterinario)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TrazaElJamon load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TrazaElJamon(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TrazaElJamon load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TrazaElJamon(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TrazaElJamon load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TrazaElJamon(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TrazaElJamon load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TrazaElJamon(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TrazaElJamon> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TrazaElJamon.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<TrazaElJamon> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TrazaElJamon.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TrazaElJamon> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TrazaElJamon.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TrazaElJamon> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TrazaElJamon.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}