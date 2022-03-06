package springframework.demo.services;

import org.springframework.stereotype.Service;
import springframework.demo.model.BezDto;

import java.util.UUID;
@Service
public class BezServiceImpl implements BezService {
    @Override
    public BezDto getBezById(UUID bezId) {
        return BezDto.builder().id(UUID.randomUUID())

            .bezName("Prima")
            .bezSize("M")
            .build();
        }

    @Override
    public BezDto saveNewBez(BezDto bezDto) {
        return BezDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBez(UUID bezId, BezDto bezDto) {

    }

    @Override
    public void deleteById(UUID bezId) {

    }
}

