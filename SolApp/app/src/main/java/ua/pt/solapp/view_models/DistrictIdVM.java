package ua.pt.solapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import javax.inject.Inject;
import ua.pt.solapp.database.entities.District;
import ua.pt.solapp.repositories.DistrictRepository;

public class DistrictIdVM extends ViewModel {

    private LiveData<District> districtID;
    private DistrictRepository districtRepository;

    @Inject
    public DistrictIdVM(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public void init() {
        if (this.districtID != null) {
            return;
        }
        districtID = districtRepository.getDistrict();
    }

    public LiveData<District> getDistrictID() {
        return this.districtID;
    }

}
