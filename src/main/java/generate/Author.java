package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * author
 * @author 
 */
@Data
public class Author implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * firstName
     */
    private String firstName;

    /**
     * lastName
     */
    private String lastName;

    private static final long serialVersionUID = 1L;
}