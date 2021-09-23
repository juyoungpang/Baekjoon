#include <iostream>

using namespace std;
int main() {
	int N;
	cin >> N;

	while (N--) {
		int s, q;
		cin >> s >> q;
		while (q--) {
			int q, p;
			cin >> q >> p;
			s += q * p;
		}
		cout << s << '\n';
	}

	return 0;
}