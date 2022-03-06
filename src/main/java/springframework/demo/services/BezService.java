package springframework.demo.services;

import springframework.demo.model.BezDto;

import java.util.UUID;

public interface BezService {
    BezDto getBezById(UUID bezId);

    BezDto saveNewBez(BezDto bezDto);

    void updateBez(UUID bezId, BezDto bezDto);

    void deleteById(UUID bezId);
}
