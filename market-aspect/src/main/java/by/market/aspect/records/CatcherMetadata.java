package by.market.aspect.records;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatcherMetadata {

    private UUID rqId;

    private String sourceSystem;

    private String sourcePerformer;

}
