package market.api.contract;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestPayload<T> extends Request implements IRequestPayload<T> {

    protected T payload;

    @Builder
    public RequestPayload(UUID rqId, String sourceSystem, String sourcePerformer, T payload) {
        super(rqId, sourceSystem, sourcePerformer);
        this.payload = payload;
    }

    public static <T> RequestPayload<T> of(IRequest request) {
        return RequestPayload.of(request, null);
    }

    public static <T> RequestPayload<T> of(IRequest request, T data) {
        return RequestPayload.<T>builder()
                .rqId(request.getId())
                .sourceSystem(request.getSourceSystem())
                .sourcePerformer(request.getSourcePerformer())
                .payload(data)
                .build();
    }

}
