package cgeo.geocaching.unifiedmap;

import cgeo.geocaching.unifiedmap.tileproviders.AbstractTileProvider;

import androidx.appcompat.app.AppCompatActivity;

import org.oscim.core.BoundingBox;

public abstract class AbstractUnifiedMap {

    protected AbstractTileProvider currentTileProvider;

    public abstract void init(AppCompatActivity activity);

    public void setTileSource(final AbstractTileProvider newSource) {
        currentTileProvider = newSource;
    };

    public void applyTheme() {
        // default is empty
    };

    public abstract void zoomToBounds(BoundingBox bounds);

    // Lifecycle methods

    protected void onResume() {
        // default is empty
    }

    protected void onPause() {
        // default is empty
    }

    protected void onDestroy() {
        // default is empty
    }

    public int getZoomMin() {
        return currentTileProvider == null ? 0 : currentTileProvider.getZoomMin();
    };

    public int getZoomMax() {
        return currentTileProvider == null ? 0 : currentTileProvider.getZoomMax();
    };

    public abstract int getCurrentZoom();

    public abstract void setZoom(int zoomLevel);
}
