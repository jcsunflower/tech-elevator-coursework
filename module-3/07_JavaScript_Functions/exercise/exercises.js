/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa is above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */

function isAdmitted(gpa, satScore, recommendation) {
    if (gpa > 4.0 || satScore > 1300) {
        return true;
    }
    else if (gpa > 3.0 && recommendation || satScore > 1200 && recommendation) {
        return true;
    } 
    else {
        return false;
    }
}

/**
 * Write a function called useParameterToFilterArray that takes a
 * function and uses that in the `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
function useParameterToFilterArray(filterFunction) {

    let unfilteredArray = [1, 2, 3, 4, 5, 6];
    let filteredNumbers = unfilteredArray.filter(filterFunction);

    return filteredNumbers;
}

/**
 * Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */

function makeNumber(first, second) {
    let concatString = first + second;
    
    return parseInt(concatString);
}

/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */

function addAll() {
    let result = 0;

    for (let i = 0; i < arguments.length; i++) {
        result += arguments[i];
    }

    return result;
}

/**
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 * 
 * @param {String[]} arr an array of Strings
 * @returns {String[]} an array of Strings where 'Happy ' is prepended to every string in the array
 */

function makeHappy(arr) {
    return prependHappy = arr.map( (arguments) => {
        return 'Happy ' + arguments;
    });
}

/**
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects. Each object contains the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * Return an array of strings that turns the JavaScript objects
 * into a mailing address in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 * 
 * @param {Object[]} arr an array of objects with various keys listed above
 * @returns {String[]} an array of strings that convert the objects into a mailing address
 */

function getFullAddressesOfProperties(arr) {
    return objectProperties = arr.map( arguments => {
        return arguments.streetNumber + ' '
        + arguments.streetName + ' '
        + arguments.streetType + ' '
        + arguments.city + ' '
        + arguments.state + ' '
        + arguments.zip;
    });
}



/**
 * Write and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It must work for strings and numbers.
 * 
 * @param {number or string} arr an array that either holds numbers or strings as its contents
 * @returns {number or string} the result will either be the largest number or the largest string
 * in the array
 */

function findLargest(arr) {
    var largest = '';

    arr.forEach ((variable) => {
        if (variable > largest) {
            largest = variable;
        }
    });
    
    return largest;
}



/** 
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 * 
 * @param {Array[]} arr an array that consist of subarrays that hold number values
 * @returns {number} the sum of all the number values in each subarray in the array
 */

function getSumOfSubArrayValues(arr) {
    let sum = 0;
    if (arr) {
        let arraySum = arr.reduce( (prev, array) => {
            let subArraySum = array.reduce( (subPrev, value) => {
                return subPrev + value;
            }, 0);
            return prev + subArraySum;
        }, 0);
        sum = arraySum;
    }
    return sum;
}
