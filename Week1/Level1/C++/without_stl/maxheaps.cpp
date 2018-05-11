#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;
ll size=0;

void swap(ll *a,ll *b){
    ll *t;
    t = a;
    a = b;
    b = t;
}

void push(vector<ll> &arr,ll x){
    arr[++size] = x;
    ll last = size;
    while(1){
        ll parent = last/2;
        if(parent==0)
            break;
        if(arr[parent] > arr[last]){
            swap(arr[parent],arr[last]);
            last = parent;
        }
        else
            break;
    }
}

void pop(vector<ll> &arr){
    arr[1] = arr[size];
    size--;
    ll last = 1;
    while(1){
        ll l,r;
        l = last*2;
        r = last*2+1;
        ll flag1 = (l<=size && arr[l]<arr[last]);
        ll flag2 = (r<=size && arr[r]<arr[last]);
        if(!flag1 && !flag2)
            break;
        ll s=last,m=LONG_MAX;
        if(l<=size && arr[l]<arr[last]){
            s = l;
            m = arr[l];
        }
        if(r<=size && arr[r]<m){
            s = r;
        }
        swap(arr[s],arr[last]);
        last = s;
    }
}

int main(){
    ll q;
    cin >> q;
    vector<ll> arr(q,LONG_MAX);
    arr[0] = 0;
    while(q--){
        ll c;
        cin >> c;
        if(c==1){
            ll x;
            cin >> x;
            push(arr,x);
        }
        else if(c==2){
            if(size == 0)
                cout << "Heap is empty!" << endl;
            else
                cout << arr[1] << endl;
        }
        else{
            if(size==0)
                cout << "Heap is empty!" << endl;
            else{
                pop(arr);
            }
        }
    }
    return 0;
}