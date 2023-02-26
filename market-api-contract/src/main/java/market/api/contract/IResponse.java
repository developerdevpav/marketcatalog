package market.api.contract;

import java.util.UUID;

public interface IResponse {

    UUID getRqId();

    String getSourceSystem();

    String getSourcePerformer();

    IStatus getStatus();

}
