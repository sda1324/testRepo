import java.util.*;

import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

import java.awt.geom.*;



class MyFrame extends JFrame {

	private char cmd = 'N';// None

	private int check = 0;

	final static int fixedWidth = 50;

	final static int fixedHeight = 50;



	public MyFrame() {

		// Frame

		setLayout(null);

		setBounds(0, 0, 800, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("MyFrame");

		setVisible(true);

		// Add panel1 & panel3 to Frame

		add(menuBar());

		add(mainBoard());

	}



	public JPanel menuBar() {

		// Panel1

		JPanel panel1 = new JPanel();

		panel1.setLayout(null);

		panel1.setBounds(0, 0, 120, 500);

		// Panel2

		JPanel panel2 = new JPanel();

		panel2.setLayout(null);

		panel2.setBounds(10, 10, 100, 200);

		panel2.setBackground(Color.BLUE);

		// Button

		JButton b1 = new JButton("사각");

		JButton b2 = new JButton("직선");

		JButton b3 = new JButton("타원");

		// ButtonOption

		b1.setBounds(0, 0, 100, 50);

		b2.setBounds(0, 75, 100, 50);

		b3.setBounds(0, 150, 100, 50);

		b1.addActionListener(new MyListener());

		b2.addActionListener(new MyListener());

		b3.addActionListener(new MyListener());

		// Add Buttons to panel2

		panel2.add(b1);

		panel2.add(b2);

		panel2.add(b3);

		// Add panel2 to panel1

		panel1.add(panel2);

		return panel1;

	}



	public JPanel mainBoard() {

		// Panel3

		JPanel panel3 = new MyPanel();

		panel3.setLayout(null);

		panel3.setBounds(120, 0, 680, 500);

		panel3.setBackground(Color.YELLOW);

		// label

		JLabel label = new JLabel("여기가 그래픽 객체를 그리는 곳 입니다.");

		label.setBounds(200, 0, 300, 50);

		// Add label to panel3

		panel3.add(label);

		return panel3;

	}



	private class MyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "사각") {

				cmd = 'R';// Rectangle

			} else if (e.getActionCommand() == "직선") {

				cmd = 'L';// Line

			} else if (e.getActionCommand() == "타원") {

				cmd = 'E';// Ellipse

			} else

				cmd = 'N';

		}

	}



	class MyPanel extends JPanel {

		ArrayList<Shape> shapeArray = new ArrayList<Shape>();

		ArrayList<Shape> littleShapeArray = new ArrayList<Shape>();

		Shape checkShape;



		// 생성자

		MyPanel() {

			addMouseListener(new MyMouseListener());

		}



		class MyMouseListener implements MouseListener {

			public void mousePressed(MouseEvent e) {

			}



			public void mouseReleased(MouseEvent e) {

			}



			public void mouseEntered(MouseEvent e) {

			}



			public void mouseExited(MouseEvent e) {

			}



			public void mouseClicked(MouseEvent e) {

				// graphic이 그려질 순서

				// drawBox를 먼저 실행해야 checkbox가 

				//도형들과 동시에 그려지는것을 방지가능

				drawBox(e);

				drawGrahic(e);

			}

		}



		// Shape 도형안에 다른 도형 겹치는 여부 확인함수

		boolean containXY(int x, int y) {

			if (shapeArray != null) {

				for (Shape s : shapeArray) {

					if (s instanceof Rectangle2D.Float) {

						Rectangle2D.Float r = (Rectangle2D.Float) s;

						for (int i = 0; i <= 50; i++) {

							if ((r.x <= x + i && x + i <= r.x + fixedWidth)

									&& (r.y <= y + i && y + i <= r.y

											+ fixedHeight))

								return true;

						}

					} else if (s instanceof Line2D.Float) {

						Line2D.Float l = (Line2D.Float) s;

						for (int i = 0; i <= 50; i++) {

							if ((l.x1 <= x + i && x + i <= l.x2)

									&& (l.y1 <= y + i && y + i <= l.y2))

								return true;

						}

					} else if (s instanceof Ellipse2D.Float) {

						Ellipse2D.Float e = (Ellipse2D.Float) s;

						for (int i = 0; i <= 50; i++) {

							if ((e.x <= x + i && x + i <= e.x + fixedWidth)

									&& (e.y <= y + i && y + i <= e.y

											+ fixedHeight))

								return true;

						}

					}

				}

			}

			return false;

		}



		// 각 버튼에 맞는 도형을 추가

		void drawGrahic(MouseEvent e) {

			Shape s;

			switch (cmd) {

			case 'R': {

				s = new Rectangle2D.Float(e.getX(), e.getY(), fixedWidth,

						fixedHeight);

				// 겹치는 경우 처리

				if (containXY(e.getX(), e.getY())) {

					repaint();

					break;

				}

				// 겹치지 않는다면 Shape 배열에 추가

				shapeArray.add(s);

				cmd = 'N';// 재초기화. 즉 다시 버튼을 눌러야 효과 적용

				repaint();

				break;

			}

			case 'L': {

				s = new Line2D.Float(e.getX(), e.getY(), e.getX() + fixedWidth,

						e.getY() + fixedHeight);

				if (containXY(e.getX(), e.getY())) {

					repaint();

					break;

				}

				shapeArray.add(s);

				cmd = 'N';

				repaint();

				break;

			}

			case 'E': {

				s = new Ellipse2D.Float(e.getX(), e.getY(), fixedWidth,

						fixedHeight);

				if (containXY(e.getX(), e.getY())) {

					repaint();

					break;

				}

				shapeArray.add(s);

				cmd = 'N';

				repaint();

				break;

			}

			default: {

				repaint();

				break;

			}

			}

		}



		// 도형 안에 마우스 클릭 여부

		void clickShape(int x, int y) {

			if (shapeArray != null) {

				for (Shape s : shapeArray) {

					// Line

					if (s instanceof Line2D.Float && cmd == 'N') {

						Line2D.Float l = (Line2D.Float) s;

						if ((l.x1 <= x && x <= l.x2)

								&& (l.y1 <= y && y <= l.y2)) {

							check = 1;

							checkShape = s;

							return;

						}

					}

					// Rectangle & Ellipse

					else if (s.contains(x, y) && cmd == 'N') {

						check = 1;

						checkShape = s;

						return;// 클릭된 도형이 있다면 함수를 빠져나옴

					}

				}

			}

			check = -1;

		}



		// 도형 선택시 checkbox 선택 및 해제

		void drawBox(MouseEvent e) {

			Shape s1, s2;

			clickShape(e.getX(), e.getY());

			switch (check) {

			case 1: {

				littleShapeArray.removeAll(littleShapeArray);//중복 체크를 방지하기 위해

				//전에 선택한 Checkbox를 삭제한다.

				if (checkShape instanceof Rectangle2D.Float) {

					Rectangle2D.Float r = (Rectangle2D.Float) checkShape;

					s1 = new Rectangle2D.Float((r.x) - 2, (r.y) - 2, 4, 4);

					s2 = new Rectangle2D.Float((r.x) + fixedWidth - 2, (r.y)

							+ fixedHeight - 2, 4, 4);

					littleShapeArray.add(s1);

					littleShapeArray.add(s2);

					repaint();

					check = 0;// 변수 재초기화

					break;

				} else if (checkShape instanceof Line2D.Float) {

					Line2D.Float l = (Line2D.Float) checkShape;

					s1 = new Rectangle2D.Float((l.x1) - 2, (l.y1) - 2, 4, 4);

					s2 = new Rectangle2D.Float((l.x2) - 2, (l.y2) - 2, 4, 4);

					littleShapeArray.add(s1);

					littleShapeArray.add(s2);

					repaint();

					check = 0;

					break;

				} else if (checkShape instanceof Ellipse2D.Float) {

					Ellipse2D.Float el = (Ellipse2D.Float) checkShape;

					s1 = new Rectangle2D.Float((el.x) - 2, (el.y) - 2, 4, 4);

					s2 = new Rectangle2D.Float((el.x) + fixedWidth - 2, (el.y)

							+ fixedHeight - 2, 4, 4);

					littleShapeArray.add(s1);

					littleShapeArray.add(s2);

					repaint();

					check = 0;

					break;

				}

			}

			case -1: {

				// 밖의 영역을 선택했다면 check box 모두 삭제한다.

				if (cmd == 'N')

					littleShapeArray.removeAll(littleShapeArray);

				check = 0;

				repaint();

				break;

			}

			default: {

				repaint();

				break;

			}

			}

		}



		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;

			/*// 앤티 에일리어싱을 설정한다.

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,

					RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setColor(Color.BLACK);

			g2.setStroke(new BasicStroke(3));*/

			for (Shape s : shapeArray)

				g2.draw(s);

			for (Shape s : littleShapeArray)

				g2.draw(s);

		}

	}

}



public class TestMain {

	public static void main(String[] args) {

		MyFrame f = new MyFrame();

	}

}