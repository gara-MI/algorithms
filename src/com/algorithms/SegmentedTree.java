package com.algorithms;


public class SegmentedTree {

    SegmentTreeNode sumTree = null;
    SegmentTreeNode maxTree = null;
    SegmentTreeNode gcdTree = null;
    int max_value = Integer.MIN_VALUE;

    SegmentedTree(int [] a) {
        gcdTree = buildGCDTree(a,0,a.length-1);
        maxTree = buildMaxTree(a,0,a.length-1);
        sumTree = buildSumTree(a,0,a.length-1);
        final SegmentTreeNode segmentTreeNode = buildTreeForTheStrangeFunction(a, 0, a.length - 1);
    }

    public static int gcd(int x, int y) {
        if(y==0)
            return x;
        return gcd(y,x%y);
    }

    class SegmentTreeNode {
        int start, end;
        int gcd,sum,max;
        SegmentTreeNode left, right;
        int value;

        public SegmentTreeNode( int start, int end ) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.value = 0;
            this.gcd=0;
            this.sum=0;
            this.max=Integer.MIN_VALUE;
        }
    }

    void update(int i, int val) {
        updateSum(sumTree, i, val);
    }

    void updateSum(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.value = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                updateSum(root.left, pos, val);
            } else {
                updateSum(root.right, pos, val);
            }
            root.value = root.left.value + root.right.value;
        }
    }

    void updateMin(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.value = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                updateMin(root.left, pos, val);
            } else {
                updateMin(root.right, pos, val);
            }
            root.value = Math.min(root.left.value , root.right.value);
        }
    }

    void updateGCD(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.value = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                updateGCD(root.left, pos, val);
            } else {
                updateGCD(root.right, pos, val);
            }
            root.value = gcd(root.left.value , root.right.value);
        }
    }

    private SegmentTreeNode buildTreeForTheStrangeFunction( int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        else {
            SegmentTreeNode node = new SegmentTreeNode(start,end);
            if(start == end) {
                node.value = nums[start];
                node.sum = nums[start];
                node.gcd = nums[start];
                node.max = nums[start];

            }
            else {
                int mid = start + (end-start)/2;
                node.left = buildTreeForTheStrangeFunction(nums,start,mid);
                node.right = buildTreeForTheStrangeFunction(nums,mid+1,end);
                node.sum = node.left.sum + node.right.sum;
                node.gcd = Math.abs(gcd(node.left.gcd , node.right.gcd));
                node.max = Math.max(node.left.max , node.right.max);
                node.value = node.gcd * (node.sum - node.max);
                max_value = Math.max(max_value,node.value);
            }
            return node;
        }
    }

    private SegmentTreeNode buildSumTree( int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        else {
            SegmentTreeNode node = new SegmentTreeNode(start,end);
            if(start == end) {
                node.value = nums[start];
            }
            else {
                int mid = start + (end-start)/2;
                node.left = buildSumTree(nums,start,mid);
                node.right = buildSumTree(nums,mid+1,end);
                node.value = node.left.value + node.right.value;
            }
            return node;
        }
    }

    private SegmentTreeNode buildMinTree( int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        else {
            SegmentTreeNode node = new SegmentTreeNode(start,end);
            if(start == end) {
                node.value = nums[start];
            }
            else {
                int mid = start + (end-start)/2;
                node.left = buildMinTree(nums,start,mid);
                node.right = buildMinTree(nums,mid+1,end);
                node.value = Math.min(node.left.value , node.right.value);
            }
            return node;
        }
    }

    private SegmentTreeNode buildMaxTree( int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        else {
            SegmentTreeNode node = new SegmentTreeNode(start,end);
            if(start == end) {
                node.value = nums[start];
            }
            else {
                int mid = start + (end-start)/2;
                node.left = buildMaxTree(nums,start,mid);
                node.right = buildMaxTree(nums,mid+1,end);
                node.value = Math.max(node.left.value , node.right.value);
            }
            return node;
        }
    }

    private SegmentTreeNode buildGCDTree( int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        else {
            SegmentTreeNode node = new SegmentTreeNode(start,end);
            if(start == end) {
                node.value = nums[start];
            }
            else {
                int mid = start + (end-start)/2;
                node.left = buildGCDTree(nums,start,mid);
                node.right = buildGCDTree(nums,mid+1,end);
                node.value = gcd(node.left.value , node.right.value);
            }
            return node;
        }
    }
    public int rangeQuery(int start,int end) {
        int g = Math.abs(gcdRangeQuery(gcdTree,start,end));
        int sum = sumRangeQuery(sumTree,start,end);
        int max = maxRangeQuery(maxTree,start,end);
        return g*(sum-max);
    }

    public int gcdRangeQuery(SegmentTreeNode root, int start, int end) {
        if(root.end == end && root.start == start) {
            return  root.value;
        }
        else {
            int mid = root.start + (root.end-root.start)/2;
            if(end <= mid) {
                return gcdRangeQuery(root.left,start,end);
            }
            else if (start >= mid +1) {
                return gcdRangeQuery(root.right,start,end);
            }
            else {
                return gcd(gcdRangeQuery(root.right,mid+1,end), gcdRangeQuery(root.left,start,mid));
            }
        }
    }

    public int sumRangeQuery(SegmentTreeNode root, int start, int end) {
        if(root.end == end && root.start == start) {
            return  root.value;
        }
        else {
            int mid = root.start + (root.end-root.start)/2;
            if(end <= mid) {
                return sumRangeQuery(root.left,start,end);
            }
            else if (start >= mid +1) {
                return sumRangeQuery(root.right,start,end);
            }
            else {
                return (sumRangeQuery(root.right,mid+1,end)+ sumRangeQuery(root.left,start,mid));
            }
        }
    }

    public int maxRangeQuery(SegmentTreeNode root, int start, int end) {
        if(root.end == end && root.start == start) {
            return  root.value;
        }
        else {
            int mid = root.start + (root.end-root.start)/2;
            if(end <= mid) {
                return maxRangeQuery(root.left,start,end);
            }
            else if (start >= mid +1) {
                return maxRangeQuery(root.right,start,end);
            }
            else {
                return Math.max(maxRangeQuery(root.right,mid+1,end) , maxRangeQuery(root.left,start,mid));
            }
        }
    }

    public int strageFunctionRangeQuery(SegmentTreeNode root, int start, int end) {
        if(root.end == end && root.start == start) {
            return  root.value;
        }
        else {
            int mid = root.start + (root.end-root.start)/2;
            if(end <= mid) {
                return strageFunctionRangeQuery(root.left,start,end);
            }
            else if (start >= mid +1) {
                return strageFunctionRangeQuery(root.right,start,end);
            }
            else {
                int max=Math.max(strageFunctionRangeQuery(root.right,mid+1,end) , strageFunctionRangeQuery(root.left,start,mid));
                int g=gcd(strageFunctionRangeQuery(root.right,mid+1,end) , strageFunctionRangeQuery(root.left,start,mid));
                int sum=(strageFunctionRangeQuery(root.right,mid+1,end) + strageFunctionRangeQuery(root.left,start,mid));
                return g*(sum-max);
            }
        }
    }


    public static void main( String[] args ) {
        //System.out.println(gcd(0,0));
        int [] a = {10,-5,5,20};
        SegmentedTree s = new SegmentedTree(a);
        System.out.println(s.rangeQuery(0, 0));
        System.out.println(s.rangeQuery(0, 1));
        System.out.println(s.rangeQuery(0, 2));
        System.out.println(s.rangeQuery(0, 3));
        System.out.println(s.rangeQuery(1, 1));
        System.out.println(s.rangeQuery(1, 2));
        System.out.println(s.rangeQuery(1, 3));
        System.out.println(s.rangeQuery(2, 2));
        System.out.println(s.rangeQuery(2, 3));
        System.out.println(s.rangeQuery(3, 3));

    }
}



