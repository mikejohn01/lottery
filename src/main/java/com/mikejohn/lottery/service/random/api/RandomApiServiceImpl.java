package com.mikejohn.lottery.service.random.api;

import com.mikejohn.lottery.config.RandomProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Slf4j
@Service
public class RandomApiServiceImpl {

    private final RandomProperties properties;
    private final RandomApi api;

    public RandomApiServiceImpl(RandomProperties properties) {
        this.properties = properties;
        Retrofit retrofit = new Retrofit.
                Builder()
                .baseUrl(properties.getHost())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.api = retrofit.create(RandomApi.class);
    }

    public Integer getRandom(int min, int max) {
        Call<Integer> call;
        int num = 1;
        int col=1;
        int base = 10;
        String format = "plain";
        String rnd = "new";
        call = api.getRandom(num, min, max, col, base, format, rnd);
        Response<Integer> response = tryToRequest(call);
        if (response.isSuccessful()) {
            return response.body();
        } else {
//            log.error(response, "no target");
            throw new RuntimeException();
        }
    }

    private <T> Response<T> tryToRequest(Call<T> call) {
        Response<T> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
//            log.error("failed request: {};", call.request());
            e.printStackTrace();
        }
        return response;
    }
}
