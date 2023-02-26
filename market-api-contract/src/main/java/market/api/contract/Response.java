package market.api.contract;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder(builderMethodName = "baseBuilder")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements IResponse {

    protected UUID rqId;

    protected String sourceSystem;

    protected String sourcePerformer;

    protected IStatus status;

}

