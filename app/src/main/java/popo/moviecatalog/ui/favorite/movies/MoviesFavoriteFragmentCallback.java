package popo.moviecatalog.ui.favorite.movies;

import popo.moviecatalog.data.source.local.entity.FilmEntity;

interface MoviesFavoriteFragmentCallback {
    void onShareClick(FilmEntity filmEntity);
}

