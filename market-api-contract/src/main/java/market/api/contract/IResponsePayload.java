package market.api.contract;

public interface IResponsePayload<T> extends IResponse {

    T getPayload();

}
