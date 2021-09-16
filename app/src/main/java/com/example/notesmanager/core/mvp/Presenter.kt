package com.example.notesmanager.core.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class Presenter<T : IView> : IPresenter<T> {

    protected val compositeDisposable = CompositeDisposable()
    protected var view: T? = null

    override fun bindView(view: T) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewReady() {}

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    protected operator fun CompositeDisposable.plusAssign(disposable: Disposable){
        this.add(disposable)
    }
}
