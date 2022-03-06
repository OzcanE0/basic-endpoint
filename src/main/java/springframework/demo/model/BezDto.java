package springframework.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BezDto {
    private UUID id;
    private String bezName;
    private String bezSize;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBezName() {
        return bezName;
    }

    public void setBezName(String bezName) {
        this.bezName = bezName;
    }

    public String getBezSize() {
        return bezSize;
    }

    public void setBezSize(String bezSize) {
        this.bezSize = bezSize;
    }

    public static BezDtoBuilder builder() {
        return new BezDtoBuilder();
    }

    public static class BezDtoBuilder {
        private UUID id;
        private String bezName;
        private String bezSize;

        BezDtoBuilder() {
        }

        public BezDtoBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public BezDtoBuilder bezName(String bezName) {
            this.bezName = bezName;
            return this;
        }

        public BezDtoBuilder bezSize(String bezSize) {
            this.bezSize = bezSize;
            return this;
        }

        public BezDto build() {
            return new BezDto(id, bezName, bezSize);
        }

        public String toString() {
            return "BezDto.BezDtoBuilder(id=" + this.id + ", bezName=" + this.bezName + ", bezSize=" + this.bezSize + ")";
        }
    }
}
