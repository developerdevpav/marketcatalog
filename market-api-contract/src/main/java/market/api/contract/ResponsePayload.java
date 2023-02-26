package market.api.contract;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePayload<T> extends Response implements IResponsePayload<T> {

    private T payload;

    @Builder
    public ResponsePayload(UUID rqId, String sourceSystem, String sourcePerformer, IStatus status, T payload) {
        super(rqId, sourceSystem, sourcePerformer, status);
        this.payload = payload;
    }

    public static <T> ResponsePayload<T> of(T data) {
        return ResponsePayload.<T>builder()
                .payload(data)
                .build();
    }

}
