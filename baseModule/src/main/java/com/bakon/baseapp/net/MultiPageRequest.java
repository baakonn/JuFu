package com.bakon.baseapp.net;

import rx.Observable;

public abstract class MultiPageRequest<T> {

    public abstract Observable<T> request(int page);

}
