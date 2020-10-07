package org.brokencodes.learning.dap.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Index {

    private long index;

    private String className;

    private String description;

    private IndexType type;

    private LocalDateTime createdOn;

}
