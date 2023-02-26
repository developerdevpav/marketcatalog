package market.api.contract;

public interface IRequestPayload<T> extends IRequest {

    T getPayload();

}
