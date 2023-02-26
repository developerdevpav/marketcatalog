package market.api.contract;

import java.util.UUID;

public interface IRequest {

    UUID getId();

    String getSourceSystem();

    String getSourcePerformer();

}
