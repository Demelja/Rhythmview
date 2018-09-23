package module.mda.rhythmview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

/*
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawView(this));
	}

	class DrawView extends SurfaceView implements SurfaceHolder.Callback {

		private DrawThread drawThread;

		public DrawView(Context context) {
			super(context);
			getHolder().addCallback(this);
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
								   int height) {

		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			drawThread = new DrawThread(getHolder());
			drawThread.setRunning(true);
			drawThread.start();
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			boolean retry = true;
			drawThread.setRunning(false);
			while (retry) {
				try {
					drawThread.join();
					retry = false;
				} catch (InterruptedException e) {
				}
			}
		}

		class DrawThread extends Thread {

			private boolean running = false;
			private SurfaceHolder surfaceHolder;

			public DrawThread(SurfaceHolder surfaceHolder) {
				this.surfaceHolder = surfaceHolder;
			}

			public void setRunning(boolean running) {
				this.running = running;
			}

			@Override
			public void run() {
				Canvas canvas;
				while (running) {
					canvas = null;
					try {
						canvas = surfaceHolder.lockCanvas(null);
						if (canvas == null)
							continue;
						canvas.drawColor(Color.GREEN);
					} finally {
						if (canvas != null) {
							surfaceHolder.unlockCanvasAndPost(canvas);
						}
					}
				}
			}
		}

	}

}

*/



public class MainActivity extends Activity {

	int sizeMin, sizeSquare, radiusCircle;
	int xSTL, ySTL, xCTL, yCTL;
	int xSTR, ySTR, xCTR, yCTR;
	int xSBL, ySBL, xCBL, yCBL;
	int xSBR, ySBR, xCBR, yCBR;
	
	int widthView, heightView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawView(this));
		
		widthView = 300;
		heightView = 300;

		if (widthView < heightView) {
			sizeMin = widthView;
		} else {
			sizeMin = heightView;
		}

		sizeSquare = Math.round(sizeMin * 45 / 100);
		xSTL = Math.round(sizeMin * 5 / 100);
		ySTL = Math.round(sizeMin * 5 / 100);
		xSTR = xSTL + sizeSquare + 1;
		ySTR = ySTL;
		xSBL = xSTL;
		ySBL = ySTL + sizeSquare + 1;
		xSBR = xSTL + sizeSquare + 1;
		ySBR = ySTL + sizeSquare + 1;
		
		radiusCircle = Math.round(sizeMin * 18 / 100);
		xCTL = Math.round(sizeMin * 27.5f / 100);
		yCTL = Math.round(sizeMin * 27.5f / 100);
		xCTR = xCTL + sizeSquare + 1;
		yCTR = yCTL;
		xCBL = xCTL;
		yCBL = yCTL + sizeSquare + 1;
		xCBR = xCTL + sizeSquare + 1;
		yCBR = yCTL + sizeSquare + 1;
		
		 
	}

	class DrawView extends View {

		Paint p;
		Rect rect, squareTL, squareTR, squareBL, squareBR;
		
		// circleTL, ...
		// colorGreen, colorRose, colorSplash
		
		public DrawView(Context context) {
			super(context);
			p = new Paint();
			rect = new Rect();
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// заливка канвы цветом
			canvas.drawARGB(80, 102, 204, 255);

			// настройка кисти
			// красный цвет
			p.setColor(Color.RED);
			// толщина линии = 10
			p.setStrokeWidth(10);

			// рисуем точку (50,50)
			canvas.drawPoint(50, 50, p);

			// рисуем линию от (100,100) до (500,50)
			canvas.drawLine(100,100,500,50,p);

			// рисуем круг с центром в (100,200), радиус = 50
			canvas.drawCircle(100, 200, 50, p);

			// рисуем прямоугольник 
			// левая верхняя точка (200,150), нижняя правая (400,200)
			canvas.drawRect(200, 150, 400, 200, p);

			// настройка объекта Rect
			// левая верхняя точка (250,300), нижняя правая (350,500)
			rect.set(250, 300, 350, 500);
			// рисуем прямоугольник из объекта rect
			canvas.drawRect(rect, p);
			
			p.setColor(Color.GREEN);
			//squareTL.set(xSTL, ySTL, xSTL + sizeSquare, ySTL + sizeSquare);
			//canvas.drawRect(squareTL, p);
			
			canvas.drawRect(xSTL, ySTL, xSTL + sizeSquare, ySTL + sizeSquare, p);
	//		p.setColor(Color.BLUE);
			canvas.drawRect(xSTR, ySTR, xSTR + sizeSquare, ySTR + sizeSquare, p);
			p.setColor(Color.YELLOW);
			p.setStyle(Paint.Style.STROKE);
			canvas.drawRect(xSBL, ySBL, xSBL + sizeSquare, ySBL + sizeSquare, p);
			p.setColor(Color.GRAY);
			p.setStrokeWidth(1);
			p.setStyle(Paint.Style.FILL_AND_STROKE);
			canvas.drawRect(xSBR, ySBR, xSBR + sizeSquare, ySBR + sizeSquare, p);
			
			p.setARGB(80, 108, 158, 200);
			canvas.drawCircle(xCTL, yCTL, radiusCircle, p);
			p.setStyle(Paint.Style.STROKE);
			canvas.drawCircle(xCTR, yCTR, radiusCircle, p);
			canvas.drawCircle(xCBL, yCBL, radiusCircle, p);
			p.setStrokeWidth(2);
			p.setStyle(Paint.Style.STROKE);
			canvas.drawCircle(xCBR, yCBR, radiusCircle, p);
			
		}

	}

}
