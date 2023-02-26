package market.api.contract;

import java.util.UUID;

public interface IRequestMutation {

    void setId(final UUID id);

    void setSourceSystem(final String sourceSystem);

    void setSourcePerformer(final String sourcePerformer);

}
