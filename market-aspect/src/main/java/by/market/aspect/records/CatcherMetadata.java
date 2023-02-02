package by.market.aspect.records;

import by.market.core.Locale;
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

    private Locale locale = Locale.RU;

}
