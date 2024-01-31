#include <iostream>
#include <vector>

using namespace std;

int main() {
    int T;
    cin >> T;
    
    for (int t = 1; t <= T; t++) {
        int N;
        cin >> N;
        vector<pair<char, int>> alphabets(N);
        
        for (int i = 0; i < N; i++) {
            cin >> alphabets[i].first >> alphabets[i].second;
        }

        cout << "#" << t << "\n";
        int curr_line = 0;
        for (auto alphabet : alphabets) {
            for (int i = 0; i < alphabet.second; i++) {
                if (curr_line == 10) {
                    cout << "\n";
                    curr_line = 0;
                }
                cout << alphabet.first;
                curr_line++;
            }
        }
        cout << "\n";
    }
    return 0;
}