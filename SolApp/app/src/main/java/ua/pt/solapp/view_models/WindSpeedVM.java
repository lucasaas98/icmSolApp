package ua.pt.solapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import javax.inject.Inject;
import ua.pt.solapp.database.entities.WindSpeed;
import ua.pt.solapp.repositories.WindSpeedRepository;

public class WindSpeedVM extends ViewModel {

    private LiveData<WindSpeed> windSpeed;
    private WindSpeedRepository windSpeedRepository;

    @Inject
    public WindSpeedVM(WindSpeedRepository weatherIDRepository) {
        this.windSpeedRepository = weatherIDRepository;
    }

    public void init() {
        if (this.windSpeed != null) {
            return;
        }
        windSpeed = windSpeedRepository.getWindSpeed();
    }

    public LiveData<WindSpeed> getWindSpeed() {
        return this.windSpeed;
    }

}
