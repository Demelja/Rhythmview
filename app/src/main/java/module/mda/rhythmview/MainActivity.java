package module.mda.rhythmview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	int sizeMin, sizeSquare, radiusCircle, xSTL, ySTL, xCTL, yCTL;
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
			squareTL.set(xSTL, ySTL, xSTL + sizeSquare, ySTL + sizeSquare);
			canvas.drawRect(squareTL, p);
			
		}

	}

}
